package com.dev_mobile_av.wear_tp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dev_mobile_av.shared.Message;
import com.dev_mobile_av.shared.MessageAdapter;
import com.dev_mobile_av.shared.ServerTask;

import org.json.JSONObject;

import java.util.ArrayList;

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

        //TODO: convert result to messagesList

        // Creates the list of messages
        ArrayList<Message> messagesList = new ArrayList<>();
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
}
