package com.dev_mobile_av.wear_tp1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

import com.dev_mobile_av.shared.NotificationProvider;
import com.dev_mobile_av.shared.Reminder;
import com.dev_mobile_av.shared.ReminderAdapter;
import com.dev_mobile_av.shared.ReminderType;

import java.util.ArrayList;

public class ShowRemindersActivity extends AppCompatActivity implements NotificationProvider
{
    protected ListView remindersList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Fetches layout views
        setContentView(R.layout.activity_show_reminders);
        remindersList = findViewById(R.id.mobileRemindersList);

        // Creates the list of reminders
        ArrayList<Reminder> reminders = (ArrayList<Reminder>) getIntent().getSerializableExtra("ReminderList");
        if (reminders == null || reminders.isEmpty())
        {
            reminders = new ArrayList<>();
            reminders.add(new Reminder("00:00", "01/02/03", ReminderType.Message, "Test title", "Test description"));
        }

        ReminderAdapter adapter = new ReminderAdapter(this, 0, reminders);
        remindersList.setAdapter(adapter);

        // Creates a notification every time a reminder is clicked
        remindersList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                createNotification((Reminder) parent.getItemAtPosition(position));
            }
        });

        // Sets up notifications
        createNotificationChannel();
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
        // Creates an intent towards the relevant activity for when the notification is clicked
        Intent intent = new Intent(this, ShowReminderActivity.class);
        intent.putExtra("Reminder", reminder);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Creates the reply actions
        RemoteInput replyRemoteInput = new RemoteInput.Builder("Reply")
                .setLabel(getResources().getString(R.string.reply_indication))
                .build();

        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_launcher_foreground, getResources().getString(R.string.reply), pendingIntent)
                .addRemoteInput(replyRemoteInput)
                .setAllowGeneratedReplies(true)
                .build();

        // Creates the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                //.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ic_notification))
                .setContentTitle(reminder.getTitle())
                .setContentText(reminder.getDescription())
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setVibrate(new long[]{500, 500})
                .setLights(Color.WHITE, 3000, 3000)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .extend(new NotificationCompat.WearableExtender().addAction(action)); // Adds the action for wearables only

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, builder.build());
    }
}
