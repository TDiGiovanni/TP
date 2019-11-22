package com.dev_mobile_av.wear_tp2;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AmbientActivity extends WearableActivity
{
    protected static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.FRANCE);

    // Layout views
    protected TextView timeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Enables Always-on
        setAmbientEnabled();
    }

    protected void setAmbientLayout()
    {
        setContentView(R.layout.activity_ambient);

        timeTextView = findViewById(R.id.timeTextView);
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails)
    {
        super.onEnterAmbient(ambientDetails);

        setAmbientLayout();

        timeTextView.setText(timeFormat.format(Calendar.getInstance().getTime()));
    }

    // The children classes must override this method to reset their layout
    @Override
    public void onExitAmbient()
    {
        super.onExitAmbient();
    }

    @Override
    public void onUpdateAmbient()
    {
        super.onUpdateAmbient();

        timeTextView.setText(timeFormat.format(Calendar.getInstance().getTime()));
    }
}
