package com.dev_mobile_av.wear_tp2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.dev_mobile_av.shared.Coordinates;
import com.dev_mobile_av.shared.Message;
import com.dev_mobile_av.shared.MessageAdapter;
import com.dev_mobile_av.shared.ServerTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.abs;

public class ShowMessagesActivity extends WearableActivity implements SensorEventListener
{
    // All attributes used for the shaking detection
    private static final float SHAKE_THRESHOLD = 400;
    private static final long REFRESH_RATE = 200;
    private SensorManager sensorManager;
    private long lastUpdate;
    private float lastX;
    private float lastY;
    private float lastZ;

    // Layout views
    protected ListView messagesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Initialise the sensor manager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Fetches layout views
        setContentView(R.layout.activity_show_messages);
        messagesListView = findViewById(R.id.messagesListView);

        // Fetches messages from the server
        List<Message> messagesList = getMessages();

        // Converts the list of messages to items displayed in the app
        MessageAdapter adapter = new MessageAdapter(this, 0, messagesList);
        messagesListView.setAdapter(adapter);

        // Show the message in details when it is clicked
        messagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(ShowMessagesActivity.this, ShowMessageActivity.class);
                intent.putExtra("Message", (Message) parent.getItemAtPosition(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPause()
    {
        super.onPause();

        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);

        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - lastUpdate) > REFRESH_RATE)
            {
                long timeDifference = (currentTime - lastUpdate);
                lastUpdate = currentTime;

                float x = event.values[0]; // In m/s2
                float y = event.values[1];
                float z = event.values[2];

                // Shake detection
                float speed = abs(x + y + z - lastX - lastY - lastZ) / timeDifference * 10000;
                if (speed > SHAKE_THRESHOLD)
                {
                    // Fetches messages from the server
                    List<Message> messagesList = getMessages();

                    // Converts the list of messages to items displayed in the app
                    MessageAdapter adapter = new MessageAdapter(this, 0, messagesList);
                    messagesListView.setAdapter(adapter);

                    Toast.makeText(this, getResources().getString(R.string.fetchedMessages), Toast.LENGTH_LONG).show();
                }

                lastX = x;
                lastY = y;
                lastZ = z;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }

    // Return the list of messages form the server //TODO: recall it when shaking the wearable or when back in active mode
    public List<Message> getMessages()
    {
        String serverUri = "https://hmin309-embedded-systems.herokuapp.com/message-exchange/messages/";
        ServerTask serverTask = new ServerTask(serverUri, false, this);
        JSONObject result = null;

        try
        {
            result = serverTask.execute().get();
        }
        catch (Exception e)
        {
            Toast.makeText(ShowMessagesActivity.this, getResources().getString(R.string.errorGeneric), Toast.LENGTH_LONG).show();
        }

        // Populate the message list with the result from the server
        List<Message> messagesList = new ArrayList<>();

        if (result != null)
        {
            Iterator<String> keys = result.keys();

            while(keys.hasNext())
            {
                String key = keys.next();
                try
                {
                    if (result.get(key) instanceof JSONObject)
                    {
                        JSONObject currentJsonMessage = (JSONObject) result.get(key);
                        String studentId = currentJsonMessage.getString("student_id");
                        String content = currentJsonMessage.getString("student_message");
                        double latitude = currentJsonMessage.getDouble("gps_lat");
                        double longitude = currentJsonMessage.getDouble("gps_long");

                        messagesList.add(new Message(studentId, content, new Coordinates(latitude, longitude)));
                    }
                }
                catch (JSONException e)
                {
                    Toast.makeText(this, getResources().getString(R.string.errorGeneric), Toast.LENGTH_LONG).show();
                }
            }
        }

        return messagesList;
    }
}
