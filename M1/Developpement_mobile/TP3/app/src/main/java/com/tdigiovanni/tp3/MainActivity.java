package com.tdigiovanni.tp3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final float MIN_THRESHOLD = 10;
    private static final float MAX_THRESHOLD = 15;
    private static final float SHAKE_THRESHOLD = 400;
    private static final float DISTANCE_THRESHOLD = 1;
    private static final long REFRESH_RATE = 200;

    private static int permissionRequest;
    private SensorManager sensorManager;
    private boolean flashlightOn = false;
    private long lastUpdate;
    private float lastX;
    private float lastY;
    private float lastZ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout sensorLinearLayout = findViewById(R.id.sensorLinearLayout);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorDesc = new StringBuilder();

        sensorDesc.append("\nAll sensors available on the phone: \n\n");
        for (Sensor sensor : sensors)
            sensorDesc.append(sensor.getName()).append("\n");

        TextView sensorTextView = new TextView(this);
        sensorTextView.setText(sensorDesc.toString());
        sensorTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        sensorLinearLayout.addView(sensorTextView);
    }

    @Override
    public void onPause() {
        super.onPause();

        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);

        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);

            long currentTime = System.currentTimeMillis();
            if ((currentTime - lastUpdate) > REFRESH_RATE) {
                long timeDifference = (currentTime - lastUpdate);
                lastUpdate = currentTime;

                float x = event.values[0]; // In m/s2
                float y = event.values[1];
                float z = event.values[2];

                // Speed detection
                if (x < MIN_THRESHOLD && x > -MIN_THRESHOLD
                        && y < MIN_THRESHOLD && y > -MIN_THRESHOLD
                        && z < MIN_THRESHOLD && z > -MIN_THRESHOLD)
                    constraintLayout.setBackgroundColor(Color.GREEN);

                else if (x > MAX_THRESHOLD || x < -MAX_THRESHOLD
                        || y > MAX_THRESHOLD || y < -MAX_THRESHOLD
                        || z > MAX_THRESHOLD || z < -MAX_THRESHOLD)
                    constraintLayout.setBackgroundColor(Color.BLACK);

                else
                    constraintLayout.setBackgroundColor(Color.RED);

                // Direction detection
                ImageView directionImage = findViewById(R.id.directionImage);
                if (y > 0 && abs(y) > abs(x))
                    directionImage.setImageResource(R.drawable.down_arrow);

                else if (y < 0 && abs(y) > abs(x))
                    directionImage.setImageResource(R.drawable.up_arrow);

                else if (x > 0 && abs(x) > abs(y))
                    directionImage.setImageResource(R.drawable.left_arrow);

                else if (x < 0 && abs(x) > abs(y))
                    directionImage.setImageResource(R.drawable.right_arrow);

                // Shake detection
                float speed = abs(x + y + z - lastX - lastY - lastZ) / timeDifference * 10000;
                if (speed > SHAKE_THRESHOLD) {
                    // Ask if we don't have permission
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this,
                                new String[]{Manifest.permission.CAMERA},
                                permissionRequest);
                    } else { // Permission has already been granted
                        Camera camera = Camera.open();

                        if (flashlightOn) {
                            Camera.Parameters parameters = camera.getParameters();
                            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                            camera.setParameters(parameters);
                            camera.startPreview();

                            flashlightOn = true;
                        } else {
                            camera.stopPreview();
                            camera.release();

                            flashlightOn = false;
                        }
                    }
                }
                lastX = x;
                lastY = y;
                lastZ = z;
            }
        }

        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            ImageView closeObjectImage = findViewById(R.id.closeObjectImage);

            float distance = event.values[0]; // In m

            if (distance < DISTANCE_THRESHOLD)
                closeObjectImage.setVisibility(View.VISIBLE);
            else
                closeObjectImage.setVisibility(View.GONE);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
