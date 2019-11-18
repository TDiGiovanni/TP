package com.dev_mobile_av.wear_tp2;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import com.dev_mobile_av.shared.Message;

public class ShowMessageActivity extends WearableActivity
{
    protected Message message;
    protected TextView messageStudentIdTextView;
    protected TextView messageContentTextView;
    protected TextView coordinatesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Gets the message from the intent
        message = (Message) getIntent().getSerializableExtra("Message");

        // Fetches all layout views
        setContentView(R.layout.activity_show_message);
        messageStudentIdTextView = findViewById(R.id.messageStudentIdTextView);
        messageContentTextView = findViewById(R.id.messageContentTextView);
        coordinatesTextView = findViewById(R.id.messageCoordinatesTextView);

        // Sets up all texts
        messageStudentIdTextView.setText(message.getStudentId());
        messageContentTextView.setText(message.getContent());
        coordinatesTextView.setText(message.getCoordinates().toString());
    }
}
