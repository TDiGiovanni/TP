package com.dev_mobile_av.wear_tp2;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.dev_mobile_av.shared.Coordinates;
import com.dev_mobile_av.shared.Message;
import com.dev_mobile_av.shared.ServerTask;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.Wearable;

import org.json.JSONObject;

public class WearSendMessageActivity extends WearableActivity
{
    protected GoogleApiClient googleApiClient;
    protected FusedLocationProviderClient fusedLocationClient;

    protected EditText studentIdEditText;
    protected EditText contentEditText;
    protected Button sendMessageButton;
    protected Button seeMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Fetches layout views
        setContentView(R.layout.activity_send_message);
        studentIdEditText = findViewById(R.id.studentIdEditText);
        contentEditText = findViewById(R.id.contentEditText);
        sendMessageButton = findViewById(R.id.sendMessageButton);
        seeMessageButton = findViewById(R.id.seeMessageButton);

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

        // Sets up the buttons
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(studentIdEditText.getText())
                || TextUtils.isEmpty(contentEditText.getText()))
                    Toast.makeText(WearSendMessageActivity.this, getResources().getString(R.string.fillInfos), Toast.LENGTH_LONG).show();

                else
                {
                    String messageStudentId = studentIdEditText.getText().toString(),
                    messageContent = contentEditText.getText().toString();

                    //TODO: if connected to phone
                    sendMessageToPhone(messageStudentId, messageContent);
                    //else
                    sendMessageToServer(messageStudentId, messageContent);
                }
            }
        });

        seeMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WearSendMessageActivity.this, ShowMessagesActivity.class);
                startActivity(intent);
            }
        });

        // Enables Always-on
        setAmbientEnabled();
    }

    // Sends the message to the server directly
    private void sendMessageToServer(String messageStudentId, String messageContent)
    {
        // Fetch the last location
        Coordinates coordinates = getLastCoordinates();


        String serverUri = "https://hmin309-embedded-systems.herokuapp.com/message-exchange/messages/";
        ServerTask serverTask = new ServerTask(serverUri, true, this);

        try
        {
            serverTask.execute(messageStudentId,
                    messageContent,
                    Double.toString(coordinates.getLatitude()),
                    Double.toString(coordinates.getLongitude()));
        }
        catch (Exception e)
        {
            Toast.makeText(WearSendMessageActivity.this, getResources().getString(R.string.errorGeneric), Toast.LENGTH_LONG).show();
        }

        Toast.makeText(WearSendMessageActivity.this, getResources().getString(R.string.sentMessage), Toast.LENGTH_LONG).show();
    }

    // Sends the message to the phone
    private void sendMessageToPhone(String messageStudentId, String messageContent)
    {
        if (googleApiClient == null)
            return;

        // Create the request
        PutDataMapRequest putRequest = PutDataMapRequest.create("/Message");
        putRequest.setUrgent();
        final DataMap map = putRequest.getDataMap();

        // Put the message
        map.putString("StudentId", messageStudentId);
        map.putString("Content", messageContent);

        Coordinates coordinates = getLastCoordinates();
        map.putDouble("Latitude", coordinates.getLatitude());
        map.putDouble("Longitude", coordinates.getLongitude());

        // Send the request
        Wearable.DataApi.putDataItem(googleApiClient, putRequest.asPutDataRequest());
    }

    // Returns the lsat coordinates of the wearable
    private Coordinates getLastCoordinates()
    {
        final Coordinates coordinates = new Coordinates();

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>()
                {
                    @Override
                    public void onSuccess(Location location)
                    {
                        // Got last known location, in some rare situations this can be null
                        if (location != null)
                        {
                            coordinates.setLatitude(location.getLatitude());
                            coordinates.setLongitude(location.getLongitude());
                        }
                    }
                });

        return coordinates;
    }
}
