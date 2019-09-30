package com.dev_mobile_av.tp1;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;

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
        remindersList = findViewById(R.id.remindersList);

        // Get the reminders to show
        ArrayList<Reminder> reminders = (ArrayList<Reminder>) getIntent().getSerializableExtra("ReminderList");
        if (reminders != null && reminders.isEmpty())
            reminders.add(new Reminder("00:00", "01/02/03", ReminderType.Message, "Test title", "Test description"));

        // Creates the list
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
        RemoteInput textRemoteInput = new RemoteInput.Builder("TextReply")
                .setLabel(getResources().getString(R.string.reply_indication))
                .build();

        RemoteInput voiceRemoteInput = new RemoteInput.Builder("VoiceReply")
                .setLabel(getResources().getString(R.string.reply_indication))
                .build();

        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_launcher_foreground, getResources().getString(R.string.reply), pendingIntent)
                .addRemoteInput(textRemoteInput)
                //.addRemoteInput(voiceRemoteInput)
                .setAllowGeneratedReplies(true)
                .build();

        // Creates the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                //.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.ic_notification))
                .setContentTitle(reminder.title)
                .setContentText(reminder.description)
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

class ReminderAdapter extends ArrayAdapter<Reminder>
{
    protected ArrayList<Reminder> reminders;
    protected static LayoutInflater inflater = null;

    public ReminderAdapter (Activity activity, int textViewResourceId, ArrayList<Reminder> reminders)
    {
        super(activity, textViewResourceId, reminders);

        try
        {
            this.reminders = reminders;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public int getCount()
    {
        return reminders.size();
    }

    public Reminder getItem(int position)
    {
        return reminders.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    public static class ViewHolder
    {
        protected TextView display_title;
        protected TextView display_date;
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        View view = convertView;
        final ViewHolder holder;

        try
        {
            if (convertView == null)
            {
                view = inflater.inflate(R.layout.reminder_item, null);
                holder = new ViewHolder();

                holder.display_title = view.findViewById(R.id.reminderTitle);
                holder.display_date = view.findViewById(R.id.reminderDate);

                view.setTag(holder);
            }
            else {
                holder = (ViewHolder) view.getTag();
            }

            holder.display_title.setText(reminders.get(position).title);
            holder.display_date.setText(reminders.get(position).getFullDate());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return view;
    }
}
