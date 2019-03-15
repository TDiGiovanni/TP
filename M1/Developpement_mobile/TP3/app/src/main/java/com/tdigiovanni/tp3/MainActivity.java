package com.tdigiovanni.tp3;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorDesc = new StringBuilder();

        for (Sensor sensor : sensors) {
            sensorDesc.append("New sensor detected: \n")
                    .append("\tName: ").append(sensor.getName()).append("\n")
                    .append("\tType: ").append(sensor.getType()).append("\n")
                    .append("Version: ").append(sensor.getVersion()).append("\n")
                    .append("Resolution (in the sensor unit): ").append(sensor.getResolution()).append("\n")
                    .append("Power in mA used by this sensor while in use: ").append(sensor.getPower()).append("\n")
                    .append("Vendor: ").append(sensor.getVendor()).append("\n")
                    .append("Maximum range of the sensor in the sensor's unit: ").append(sensor.getMaximumRange()).append("\n")
                    .append("Minimum delay allowed between two events in  microsecond (or zero if this sensor only returns a value when the data it's measuring changes): ").append(sensor.getMinDelay()).append("\n");
        }

        Toast.makeText(this, sensorDesc.toString(), Toast.LENGTH_LONG).show();
    }
}
