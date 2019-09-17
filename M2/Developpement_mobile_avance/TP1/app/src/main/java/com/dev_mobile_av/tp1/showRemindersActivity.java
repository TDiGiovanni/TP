package com.dev_mobile_av.tp1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class showRemindersActivity extends AppCompatActivity implements NotificationProvider
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reminders);

        ListView remindersList = findViewById(R.id.remindersList);

        Intent intent = getIntent();
        String fileName = intent.getStringExtra("FILE_NAME");
        ArrayList<String> allReminders = new ArrayList<>();

        // Reads the file
        try
        {
            FileInputStream file = openFileInput(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file));
            allReminders.add(bufferedReader.readLine());
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        // Creates the list
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, allReminders);
        remindersList.setAdapter(adapter);

        // Creates a notification every time a reminder is clicked
        remindersList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                createNotification("Test","Test");
            }
        });
    }


    @Override
    public void createNotificationChannel()
    {
        // Only on API 26+ because the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    @Override
    public void createNotification(String title, String description)
    {
        createNotificationChannel();

        // Creates an intent towards the relevant activity for when the notification is clicked
        Intent intent = new Intent(this, showRemindersActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // Creates the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                //.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ic_notification))
                .setContentTitle(title)
                .setContentText(description)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setVibrate(new long[]{500, 500})
                .setLights(Color.WHITE, 3000, 3000)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, builder.build());
    }
}
