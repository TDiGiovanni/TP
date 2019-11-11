package com.dev_mobile_av.wear_tp2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dev_mobile_av.shared.Message;

import java.util.ArrayList;

public class SendMessageActivity extends AppCompatActivity
{
    protected ArrayList<Message> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        final EditText timeEditText = findViewById(R.id.timeEditText);
        final EditText dateEditText = findViewById(R.id.dateEditText);
        final EditText titleEditText = findViewById(R.id.titleEditText);
        final EditText contentEditText = findViewById(R.id.contentEditText);
        Button addReminderButton = findViewById(R.id.sendMessageButton);
        Button showRemindersButton = findViewById(R.id.showMessagesButton);

        messages = new ArrayList<>();

        addReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(timeEditText.getText())
                        || TextUtils.isEmpty(dateEditText.getText())
                        || TextUtils.isEmpty(titleEditText.getText())
                        || TextUtils.isEmpty(contentEditText.getText()))
                    Toast.makeText(SendMessageActivity.this, "You must fill out all the informations", Toast.LENGTH_SHORT).show();

                else
                {
                    Message message = new Message(timeEditText.getText().toString(),
                            dateEditText.getText().toString(),
                            titleEditText.getText().toString(),
                            contentEditText.getText().toString());

                    messages.add(message);
                }
            }
        });

        showRemindersButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SendMessageActivity.this, ShowMessagesActivity.class);
                intent.putExtra("ReminderList", messages);
                startActivity(intent);
            }
        });
    }
}
