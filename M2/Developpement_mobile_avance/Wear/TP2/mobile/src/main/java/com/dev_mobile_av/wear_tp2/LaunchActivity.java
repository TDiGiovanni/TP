package com.dev_mobile_av.wear_tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.wearable.WearableListenerService;

public class LaunchActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Start the listener service
        Intent intent = new Intent(this, WearableListenerService.class);
        startService(intent);
        Toast.makeText(this, getResources().getString(R.string.startedService), Toast.LENGTH_SHORT).show();

        // End the activity
        finish();
    }
}
