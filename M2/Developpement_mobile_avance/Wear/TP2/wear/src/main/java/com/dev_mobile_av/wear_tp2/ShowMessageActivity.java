package com.dev_mobile_av.wear_tp2;

import android.os.Bundle;
import android.widget.TextView;

import com.dev_mobile_av.shared.Message;

public class ShowMessageActivity extends AmbientActivity
{
    protected Message message;
    protected TextView messageStudentIdTextView;
    protected TextView messageContentTextView;
    protected TextView coordinatesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Fetches all layout views
        fetchLayoutViews();

        // Gets the message from the intent
        message = (Message) getIntent().getSerializableExtra("Message");

        // Sets up all texts
        messageStudentIdTextView.setText(message.getStudentId());
        messageContentTextView.setText(message.getContent());
        coordinatesTextView.setText(message.getCoordinates().toString());
    }

    @Override
    protected void fetchLayoutViews()
    {
        setContentView(R.layout.activity_show_message);

        messageStudentIdTextView = findViewById(R.id.messageStudentIdTextView);
        messageContentTextView = findViewById(R.id.messageContentTextView);
        coordinatesTextView = findViewById(R.id.messageCoordinatesTextView);
    }

    @Override
    public void onExitAmbient()
    {
        super.onExitAmbient();

        fetchLayoutViews();
    }
}
