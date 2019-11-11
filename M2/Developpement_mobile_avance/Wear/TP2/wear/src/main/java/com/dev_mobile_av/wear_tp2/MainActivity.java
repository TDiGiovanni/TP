package com.dev_mobile_av.wear_tp2;

import android.location.Location;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;

import com.dev_mobile_av.shared.Message;
import com.dev_mobile_av.shared.MessageAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.Wearable;

import java.util.ArrayList;

public class MainActivity extends WearableActivity
{
    protected GoogleApiClient googleApiClient;
    protected FusedLocationProviderClient fusedLocationClient;
    protected ListView remindersList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Fetches layout views
        setContentView(R.layout.activity_main);
        remindersList = findViewById(R.id.wearRemindersList);

        // Creates the list of messages
        ArrayList<Message> messages = (ArrayList<Message>) getIntent().getSerializableExtra("ReminderList");
        if (messages == null || messages.isEmpty())
        {
            messages = new ArrayList<>();
            messages.add(new Message("00:00", "01/02/03", "Test title", "Test description"));
        }

        MessageAdapter adapter = new MessageAdapter(this, 0, messages);
        remindersList.setAdapter(adapter);

        // Sends coordinates every time a reminder is clicked
        remindersList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                sendCoordinates();
            }
        });

        // Creates the Google client to communicate with the wearable
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

        // Client used to fetch coordinates
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Enables Always-on
        setAmbientEnabled();
    }

    // Sends coordinates to the phone
    private void sendCoordinates()
    {
        if (googleApiClient == null)
            return;

        PutDataMapRequest putRequest = PutDataMapRequest.create("/Coordinates");
        putRequest.setUrgent();
        final DataMap map = putRequest.getDataMap();

        //TODO: send reminder infos

        // Put the GPS coordinates
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>()
                {
                    @Override
                    public void onSuccess(Location location)
                    {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null)
                        {
                            map.putDouble("Latitude", location.getLatitude());
                            map.putDouble("Longitude", location.getLongitude());
                        }
                    }
                });

        Wearable.DataApi.putDataItem(googleApiClient, putRequest.asPutDataRequest());
    }
}
