package com.dev_mobile_av.wear_tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.RemoteInput;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.dev_mobile_av.shared.NotificationProvider;
import com.dev_mobile_av.shared.Reminder;

import java.util.Objects;

public class ShowReminderActivity extends AppCompatActivity implements NotificationProvider
{
    protected Reminder reminder;
    protected TextView reminderTitleTextView;
    protected TextView reminderDateTimeTextView;
    protected TextView reminderTypeTextView;
    protected TextView reminderDescriptionTextView;
    protected TextView replyTextView;
    protected TextView coordinatesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Fetches all layout views
        setContentView(R.layout.activity_show_reminder);
        reminder = (Reminder) getIntent().getSerializableExtra("Reminder");
        reminderTitleTextView = findViewById(R.id.reminderTitleTextView);
        reminderDateTimeTextView = findViewById(R.id.reminderDateTimeTextView);
        reminderTypeTextView = findViewById(R.id.reminderTypeTextView);
        reminderDescriptionTextView = findViewById(R.id.reminderDescriptionTextView);
        replyTextView = findViewById(R.id.replyTextView);
        coordinatesTextView = findViewById(R.id.coordinatesTextView);

        // Sets up notifications
        createNotificationChannel();

        // Sets up all texts
        reminderTitleTextView.setText(reminder.getTitle());
        reminderDateTimeTextView.setText(reminder.getFullDate());
        reminderTypeTextView.setText(getResources().getString(R.string.type) + ": " + reminder.getType().toString());
        reminderDescriptionTextView.setText(reminder.getDescription());
        replyTextView.setText(getReply(getIntent()));
        coordinatesTextView.setText(getCoordinates());
    }

    private String getReply(Intent intent)
    {
        String result = getResources().getString(R.string.reply) + ": ";

        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null)
            result += Objects.requireNonNull(remoteInput.getCharSequence("Reply")).toString();

        createNotification(null);

        return result;
    }

    private String getCoordinates()
    {
        String result = getResources().getString(R.string.coordinates) + ": ";

        result += "(" + getIntent().getDoubleExtra("Latitude", 0) + ", ";
        result += getIntent().getDoubleExtra("Longitude", 0) + ")";

        return result;
    }

    @Override
    public void createNotificationChannel()
    {
        // Only on API 26+ because the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null)
                notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void createNotification(Reminder reminder)
    {
        // Builds a new notification, which informs the user that the system handled their interaction with the previous notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentText(getString(R.string.replied));

        // Issues the new notification
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, builder.build());
    }
}
