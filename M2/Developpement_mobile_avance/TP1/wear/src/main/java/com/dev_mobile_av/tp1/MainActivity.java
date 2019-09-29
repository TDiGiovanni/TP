package com.dev_mobile_av.tp1;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;

public class MainActivity extends WearableActivity
{
    protected GoogleApiClient googleApiClient;
    protected TextView testTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testTextView = findViewById(R.id.text);

        // Creates the Google client
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks()
                {
                    @Override
                    public void onConnected(Bundle connectionHint)
                    {

                    }
                    @Override
                    public void onConnectionSuspended(int cause)
                    {

                    }
                })
                .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener()
                {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult result)
                    {

                    }
                })
                .addApi(Wearable.API)
                .build();
        googleApiClient.connect();

        // Enables Always-on
        setAmbientEnabled();
    }

    private void sendReply(String reply)
    {
        if (googleApiClient == null)
            return;

        PutDataMapRequest putRequest = PutDataMapRequest.create("/REPLY");
        DataMap map = putRequest.getDataMap();

        map.putString("Reply", reply);

        Wearable.DataApi.putDataItem(googleApiClient,  putRequest.asPutDataRequest());
    }
}
