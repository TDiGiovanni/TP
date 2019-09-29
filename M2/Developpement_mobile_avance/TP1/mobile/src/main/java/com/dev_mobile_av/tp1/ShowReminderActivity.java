package com.dev_mobile_av.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowReminderActivity extends AppCompatActivity
{
    protected Reminder reminder;
    protected TextView reminderTitleTextView;
    protected TextView reminderDateTextView;
    protected TextView reminderTimeTextView;
    protected TextView reminderTypeTextView;
    protected TextView reminderDescriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reminder);

        reminder = (Reminder) getIntent().getSerializableExtra("Reminder");
        reminderTitleTextView = findViewById(R.id.reminderTitleTextView);
        reminderDateTextView = findViewById(R.id.reminderDateTextView);
        reminderTimeTextView = findViewById(R.id.reminderTimeTextView);
        reminderTypeTextView = findViewById(R.id.reminderTypeTextView);
        reminderDescriptionTextView = findViewById(R.id.reminderDescriptionTextView);

        reminderTitleTextView.setText(reminder.title);
        reminderDateTextView.setText(reminder.date);
        reminderTimeTextView.setText(reminder.time);
        reminderTypeTextView.setText(reminder.type.toString());
        reminderDescriptionTextView.setText(reminder.description);
    }
}
