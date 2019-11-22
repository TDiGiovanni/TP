package com.dev_mobile_av.wear_tp2;

import android.os.Bundle;
import android.widget.TextView;

import com.dev_mobile_av.shared.Message;

public class ShowMessageActivity extends AmbientActivity
{
    protected Message message;

    // Layout views
    protected TextView messageStudentIdTextView;
    protected TextView messageContentTextView;
    protected TextView coordinatesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Gets the message from the intent
        message = (Message) getIntent().getSerializableExtra("Message");

        // Fetches all layout views and sets up their behavior
        setUpLayout();
    }

    // Fetches all layout views and sets up their behavior
    protected void setUpLayout()
    {
        setContentView(R.layout.activity_show_message);

        // Fetches the layout views
        messageStudentIdTextView = findViewById(R.id.messageStudentIdTextView);
        messageContentTextView = findViewById(R.id.messageContentTextView);
        coordinatesTextView = findViewById(R.id.messageCoordinatesTextView);

        // Sets up all texts
        messageStudentIdTextView.setText(message.getStudentId());
        messageContentTextView.setText(message.getContent());
        coordinatesTextView.setText(message.getCoordinates().toString());
    }

    @Override
    public void onExitAmbient()
    {
        super.onExitAmbient();

        setUpLayout();
    }
}
