package com.dev_mobile_av.wear_tp2;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.dev_mobile_av.shared.Message;
import com.dev_mobile_av.shared.MessageAdapter;
import com.dev_mobile_av.shared.ServerTask;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class ShowMessagesActivity extends AmbientActivity implements SensorEventListener
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
    protected ListView messageListView;

    protected MessageAdapter adapter; // Adapter for the message list

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Initialise the sensor manager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Adapter to convert the list of messages to items displayed in the app
        adapter = new MessageAdapter(this, 0, new ArrayList<Message>());

        // Fetches all layout views and sets up their behavior
        setUpLayout();

        // Fetches messages from the server
        fetchMessages();
    }

    // Fetches all layout views and sets up their behavior
    protected void setUpLayout()
    {
        setContentView(R.layout.activity_show_messages);

        messageListView = findViewById(R.id.messageListView);
        messageListView.setAdapter(adapter);

        // Show the message in details when it is clicked
        messageListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(ShowMessagesActivity.this, ShowMessageActivity.class);
                intent.putExtra("Message", adapter.getItem(position));
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
    }

    @Override
    public void onExitAmbient()
    {
        super.onExitAmbient();

        setUpLayout();

        // Also refresh the list of messages when we're back in active mode
        fetchMessages();
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
                    fetchMessages();

                    Toast.makeText(this, getResources().getString(R.string.updatedMessages), Toast.LENGTH_LONG).show();
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

    // Populate the message list with the result from the server
    public void fetchMessages()
    {
        String serverUri = "https://hmin309-embedded-systems.herokuapp.com/message-exchange/messages/";
        ServerTask serverTask = new ServerTask(serverUri, false, adapter, this);
        serverTask.execute();
    }
}
