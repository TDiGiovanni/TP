package com.dev_mobile_av.shared;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents an asynchronous task used to communicate with the server
 */
public class ServerTask extends AsyncTask<String, Void, List<Message>>
{
    private String url;                             // Address to connect to
    private boolean isPost;                         // Determines if the HTTP request is POST or GET

    private MessageAdapter adapter;                 // Adapter for the message list

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
        JSONObject jsonResult = null;
        List<Message> result = new ArrayList<>();

        try
        {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(15000); // In milliseconds
            connection.setConnectTimeout(15000);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");

            if (this.isPost)
            {
                connection.setRequestMethod("POST");

                // Building
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
                writer.write(parameters[0]); // Student id
                writer.write(parameters[1]); // Message content
                writer.write(parameters[2]); // Latitude
                writer.write(parameters[3]); // Longitude

                // Closing
                writer.flush();
                writer.close();
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

            // Disconnecting
            connection.disconnect();

            // Store the answer
            jsonResult = new JSONObject(response.toString());
        }
        catch (IOException | JSONException e)
        {
            e.printStackTrace();
        }

        // Populate the message list with the json
        if (jsonResult != null)
        {
            Iterator<String> keys = jsonResult.keys();

            while(keys.hasNext())
            {
                String key = keys.next();
                try
                {
                    if (jsonResult.get(key) instanceof JSONObject)
                    {
                        JSONObject currentJsonMessage = (JSONObject) jsonResult.get(key);
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