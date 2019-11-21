package com.dev_mobile_av.wear_tp2;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import java.util.Calendar;

public class AmbientActivity extends WearableActivity
{
    protected int currentLayoutId;

    protected TextView timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_ambient);
        //timeTextView = findViewById(R.id.timeTextView);

        // Enables Always-on
        setAmbientEnabled();
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails)
    {
        super.onEnterAmbient(ambientDetails);

        //setContentView(R.layout.activity_ambient); //TODO: not good
        //timeTextView.setText(Calendar.getInstance().getTime().toString());
    }

    @Override
    public void onExitAmbient()
    {
        super.onExitAmbient();

        //setContentView(currentLayoutId);
    }

    @Override
    public void onUpdateAmbient()
    {
        super.onUpdateAmbient();

        //timeTextView.setText(Calendar.getInstance().getTime().toString());
    }
}
