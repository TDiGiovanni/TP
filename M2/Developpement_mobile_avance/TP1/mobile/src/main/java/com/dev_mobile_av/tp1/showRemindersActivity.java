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

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.Wearable;

import java.util.ArrayList;

public class showRemindersActivity extends AppCompatActivity implements NotificationProvider
{
    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reminders);

        ListView remindersList = findViewById(R.id.remindersList);

        Intent intent = getIntent();
        ArrayList<Reminder> reminders = (ArrayList<Reminder>) intent.getSerializableExtra("REMINDER_LIST");

        if (reminders == null)
        {
            reminders = new ArrayList<>();
            reminders.add((Reminder) intent.getSerializableExtra("REMINDER"));
        }

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


        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(Bundle connectionHint) {
                    }
                    @Override
                    public void onConnectionSuspended(int cause) {
                    }
                })
                .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(ConnectionResult result) {
                    }
                })
                .addApi(Wearable.API)
                .build();
        googleApiClient.connect();
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
    public void createNotification(Reminder reminder)
    {
        RemoteInput remoteInput = new RemoteInput.Builder("Result key")
                .setLabel("Enter your reply")
                .build();

        // Creates an intent towards the relevant activity for when the notification is clicked
        Intent intent = new Intent(this, showRemindersActivity.class);
        intent.putExtra("REMINDER", reminder);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Create the reply action and add the remote input
        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_launcher_foreground, getResources().getString(R.string.reply_action), pendingIntent)
                .addRemoteInput(remoteInput)
                .setAllowGeneratedReplies(false)
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
                .extend(new NotificationCompat.WearableExtender().addAction(action));

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, builder.build());
    }

    private void syncDataItem(String reply)
    {
        if (googleApiClient == null)
            return;

        final PutDataMapRequest putRequest = PutDataMapRequest.create("/REPLY");
        final DataMap map = putRequest.getDataMap();
        map.putString("Reply", reply);
        Wearable.DataApi.putDataItem(googleApiClient,  putRequest.asPutDataRequest());
    }
}

class ReminderAdapter extends ArrayAdapter<Reminder>
{
    private ArrayList<Reminder> reminders;
    private static LayoutInflater inflater = null;

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

    public Reminder getItem(Reminder reminder)
    {
        return reminder;
    }

    public long getItemId(int position)
    {
        return position;
    }

    public static class ViewHolder
    {
        public TextView display_title;
        public TextView display_date;
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
