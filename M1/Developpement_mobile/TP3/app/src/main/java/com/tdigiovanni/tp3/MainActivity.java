package com.tdigiovanni.tp3;

import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final float MIN_THRESHOLD = 1;
    private static final float MAX_THRESHOLD = 10;
    private static final float SHAKE_THRESHOLD = 1;
    private boolean flashlightOn = false;

    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout sensorLinearLayout = findViewById(R.id.sensorLinearLayout);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorDesc = new StringBuilder();

        sensorDesc.append("All sensors available on the phone: \n\n");
        for (Sensor sensor : sensors) {
            sensorDesc.append(sensor.getName()).append("\n");
        }

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
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);

            float x = event.values[0]; // In m/s2
            float y = event.values[1];
            float z = event.values[2];

            float speed = (x + y + z) / 10000;

            if (speed > SHAKE_THRESHOLD) {
                Camera camera = Camera.open();

                if (flashlightOn) {
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(parameters);
                    camera.startPreview();

                    flashlightOn = true;
                }
                else {
                    camera.stopPreview();
                    camera.release();

                    flashlightOn = false;
                }
            }

            if (x < MIN_THRESHOLD
                    || y < MIN_THRESHOLD
                    || z < MIN_THRESHOLD)
                constraintLayout.setBackgroundColor(Color.GREEN);

            else if (x > MAX_THRESHOLD
                    || y > MAX_THRESHOLD
                    || z > MAX_THRESHOLD)
                constraintLayout.setBackgroundColor(Color.BLACK);

            else
                constraintLayout.setBackgroundColor(Color.RED);
        }

        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            float distance = event.values[0]; // In meters

            //TODO
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
