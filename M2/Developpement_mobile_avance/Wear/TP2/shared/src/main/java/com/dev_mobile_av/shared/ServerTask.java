package com.dev_mobile_av.shared;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Represents an asynchronous task used to communicate with the server
 */
public class ServerTask extends AsyncTask<String, Void, JSONObject>
{
    private String url;                             // Address to connect to
    private boolean isPost;                         // Determines if the HTTP request is POST or GET
    private final ProgressDialog progressDialog;    // UI indication of the task

    public ServerTask(String url, boolean isPost, Context context)
    {
        this.url = url;
        this.isPost = isPost;
        this.progressDialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute()
    {
        this.progressDialog.setMessage("Processing...");
        this.progressDialog.show();
    }

    @Override
    protected JSONObject doInBackground(String... parameters)
    {
        try
        {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000);       // In milliseconds
            connection.setConnectTimeout(10000);    // In milliseconds
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            if (this.isPost)
            {
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

            connection.disconnect();

            return new JSONObject(response.toString());
        }
        catch (Exception e)
        {
            return null;
        }

    }

    @Override
    protected void onPostExecute(JSONObject result)
    {
        this.progressDialog.dismiss();
    }

    @Override
    protected void onCancelled()
    {
        this.progressDialog.dismiss();
    }
}