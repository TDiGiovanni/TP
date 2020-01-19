package com.dev_mobile_av.shared;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an asynchronous task used to communicate with the server
 */
public class ServerTask extends AsyncTask<String, Void, List<Message>>
{
    private String url;                             // Address to connect to
    private boolean isPost;                         // Determines if the HTTP request is POST or GET

    private MessageAdapter adapter;                 // Adapter for the message list (used in the case of a GET request)

    private final ProgressDialog progressDialog;    // UI indication of the task

    public ServerTask(String url, boolean isPost, MessageAdapter adapter, Context context)
    {
        this.url = url;
        this.isPost = isPost;
        this.adapter = adapter;
        this.progressDialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute()
    {
        this.progressDialog.setMessage("Processing...");
        this.progressDialog.show();

        if (adapter != null)
            adapter.clear();
    }

    @Override
    protected List<Message> doInBackground(String... parameters)
    {
        JSONArray jsonResult = null;
        List<Message> result = new ArrayList<>();

        try
        {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(20000); // In milliseconds
            connection.setConnectTimeout(20000);
            connection.setDoInput(true);

            if (this.isPost)
            {
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setDoOutput(true);

                // Building the json body
                JSONObject jsonParameters = new JSONObject();
                jsonParameters.put("student_id", parameters[0]);        // Student id
                jsonParameters.put("student_message", parameters[1]);   // Message content
                jsonParameters.put("gps_lat", parameters[2]);           // Latitude
                jsonParameters.put("gps_long", parameters[3]);          // Longitude

                // Writing in the output
                OutputStream os = connection.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
                writer.write(jsonParameters.toString());

                // Closing the writer
                writer.flush();
                writer.close();
                os.close();
            }
            else
            {
                connection.setRequestMethod("GET");
            }

            // Connecting
            connection.connect();

            // Reading the answer
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line = reader.readLine();
            while (line != null)
            {
                response.append(line).append('\n');

                line = reader.readLine();
            }
            reader.close();

            // Store the answer
            jsonResult = new JSONArray(response.toString());

            // Disconnecting
            connection.disconnect();
        }
        catch (IOException | JSONException e)
        {
            e.printStackTrace();
        }

        // Populate the message list with the json
        if (jsonResult != null)
        {
            for (int i = 0; i < jsonResult.length(); i++)
            {
                try
                {
                    if (jsonResult.get(i) instanceof JSONObject)
                    {
                        JSONObject currentJsonMessage = (JSONObject) jsonResult.get(i);
                        String studentId = currentJsonMessage.getString("student_id");
                        String content = currentJsonMessage.getString("student_message");
                        double latitude = currentJsonMessage.getDouble("gps_lat");
                        double longitude = currentJsonMessage.getDouble("gps_long");

                        result.add(new Message(studentId, content, new Coordinates(latitude, longitude)));
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    @Override
    protected void onPostExecute(List<Message> result)
    {
        if (adapter != null)
            adapter.addAll(result);

        this.progressDialog.dismiss();
    }

    @Override
    protected void onCancelled()
    {
        this.progressDialog.dismiss();
    }
}