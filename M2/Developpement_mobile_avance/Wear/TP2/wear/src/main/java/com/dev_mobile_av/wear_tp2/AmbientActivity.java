package com.dev_mobile_av.wear_tp2;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import java.util.Calendar;

public class AmbientActivity extends WearableActivity
{
    protected TextView timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        fetchLayoutViews();

        // Enables Always-on
        setAmbientEnabled();
    }

    // The children classes must override this method
    protected void fetchLayoutViews()
    {
        setContentView(R.layout.activity_ambient);

        timeTextView = findViewById(R.id.timeTextView);
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails)
    {
        super.onEnterAmbient(ambientDetails);

        fetchLayoutViews();

        timeTextView.setText(Calendar.getInstance().getTime().toString());
    }

    // The children classes must override this method and call fetchLayoutViews()
    @Override
    public void onExitAmbient()
    {
        super.onExitAmbient();
    }

    @Override
    public void onUpdateAmbient()
    {
        super.onUpdateAmbient();

        timeTextView.setText(Calendar.getInstance().getTime().toString());
    }
}
