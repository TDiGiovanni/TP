package com.dev_mobile_av.shared;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Represents an asynchronous task used to communicate with the server
 */
public class ServerTask extends AsyncTask<Void, Void, JSONObject>
{
    private String url;                             // Address to connect to
    private final ProgressDialog progressDialog;    // UI indication of the task

    ServerTask(String url, Context context)
    {
        this.url = url;
        this.progressDialog = new ProgressDialog(context);
    }

    @Override
    protected void onPreExecute()
    {
        this.progressDialog.setMessage("Processing...");
        this.progressDialog.show();
    }

    @Override
    protected JSONObject doInBackground(Void... params)
    {
        try
        {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(10000); // In milliseconds
            connection.setConnectTimeout(10000); // In milliseconds
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");

            /* USED FOR POST REQUESTS
            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("username", username)
                    .appendQueryParameter("password", password);
            String query = builder.build().getEncodedQuery();

            OutputStream output = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(output, StandardCharsets.UTF_8));
            writer.write(query);
            writer.flush();
            writer.close();
            output.close();
            */

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