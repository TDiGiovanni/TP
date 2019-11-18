package com.dev_mobile_av.wear_tp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dev_mobile_av.shared.Coordinates;
import com.dev_mobile_av.shared.Message;
import com.dev_mobile_av.shared.MessageAdapter;
import com.dev_mobile_av.shared.ServerTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShowMessagesActivity extends WearableActivity
{
    protected ListView messagesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Fetches layout views
        setContentView(R.layout.activity_show_messages);
        messagesListView = findViewById(R.id.messagesListView);

        // Fetches messages from the server
        List<Message> messagesList = getMessages();

        // Converts the list of messages to items displayed in the app
        MessageAdapter adapter = new MessageAdapter(this, 0, messagesList);
        messagesListView.setAdapter(adapter);

        // Show the message in details when it is clicked
        messagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(ShowMessagesActivity.this, ShowMessageActivity.class);
                intent.putExtra("Message", (Message) parent.getItemAtPosition(position));
                startActivity(intent);
            }
        });
    }

    // Return the list of messages form the server //TODO: recall it when shaking the wearable or when back in active mode
    public List<Message> getMessages()
    {
        String serverUri = "https://hmin309-embedded-systems.herokuapp.com/message-exchange/messages/";
        ServerTask serverTask = new ServerTask(serverUri, false, this);
        JSONObject result = null;

        try
        {
            result = serverTask.execute().get();
        }
        catch (Exception e)
        {
            Toast.makeText(ShowMessagesActivity.this, getResources().getString(R.string.errorGeneric), Toast.LENGTH_LONG).show();
        }

        // Populate the message list with the result from the server
        List<Message> messagesList = new ArrayList<>();

        if (result != null)
        {
            Iterator<String> keys = result.keys();

            while(keys.hasNext())
            {
                String key = keys.next();
                try
                {
                    if (result.get(key) instanceof JSONObject)
                    {
                        JSONObject currentJsonMessage = (JSONObject) result.get(key);
                        String studentId = currentJsonMessage.getString("student_id");
                        String content = currentJsonMessage.getString("student_message");
                        double latitude = currentJsonMessage.getDouble("gps_lat");
                        double longitude = currentJsonMessage.getDouble("gps_long");

                        messagesList.add(new Message(studentId, content, new Coordinates(latitude, longitude)));
                    }
                }
                catch (JSONException e)
                {
                    Toast.makeText(ShowMessagesActivity.this, getResources().getString(R.string.errorGeneric), Toast.LENGTH_LONG).show();
                }
            }
        }

        return messagesList;
    }
}
