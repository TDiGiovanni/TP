package com.dev_mobile_av.wear_tp2;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.dev_mobile_av.shared.Coordinates;
import com.dev_mobile_av.shared.ServerTask;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.Wearable;

public class SendMessageActivity extends AmbientActivity
{
    // Phone communication
    protected GoogleApiClient googleApiClient;
    protected boolean isConnected;

    protected FusedLocationProviderClient fusedLocationClient;  // Client to get coordinates

    // Layout views
    protected EditText studentIdEditText;
    protected EditText contentEditText;
    protected Button sendMessageButton;
    protected Button seeMessagesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Creates the Google client to communicate with the phone
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

        // Check if the wearable is connected to the phone
        checkHandheldConnection();

        // Client used to fetch coordinates
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // Fetches layout views and sets up their behavior
        setUpLayout();
    }

    // Fetches layout views and sets up their behavior
    protected void setUpLayout()
    {
        setContentView(R.layout.activity_send_message);

        studentIdEditText = findViewById(R.id.studentIdEditText);
        contentEditText = findViewById(R.id.contentEditText);
        sendMessageButton = findViewById(R.id.sendMessageButton);
        seeMessagesButton = findViewById(R.id.seeMessagesButton);

        // Sets up the buttons
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(studentIdEditText.getText())
                        || TextUtils.isEmpty(contentEditText.getText()))
                    Toast.makeText(SendMessageActivity.this, getResources().getString(R.string.fillInfos), Toast.LENGTH_LONG).show();

                else
                {
                    String messageStudentId = studentIdEditText.getText().toString(),
                            messageContent = contentEditText.getText().toString();

                    // Only go through the phone if it's connected
                    if (isConnected)
                        sendMessageToPhone(messageStudentId, messageContent);
                    else
                        sendMessageToServer(messageStudentId, messageContent);
                }
            }
        });

        seeMessagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendMessageActivity.this, ShowMessagesActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onExitAmbient()
    {
        super.onExitAmbient();

        setUpLayout();
    }

    protected void checkHandheldConnection()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                isConnected = !(Wearable.NodeApi.getConnectedNodes(googleApiClient).await().getNodes().isEmpty());
            }
        }).start();
    }

    // Sends the message to the server directly
    protected void sendMessageToServer(String messageStudentId, String messageContent)
    {
        // Fetch the last location
        Coordinates coordinates = getLastCoordinates();

        // Initialise the server task
        String serverUri = "https://hmin309-embedded-systems.herokuapp.com/message-exchange/messages/";
        ServerTask serverTask = new ServerTask(serverUri, true, null, this);

        // Execute the server task
        try
        {
            serverTask.execute(messageStudentId,
                    messageContent,
                    Double.toString(coordinates.getLatitude()),
                    Double.toString(coordinates.getLongitude()));

            Toast.makeText(SendMessageActivity.this, getResources().getString(R.string.sentMessage), Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            Toast.makeText(SendMessageActivity.this, getResources().getString(R.string.errorGeneric), Toast.LENGTH_LONG).show();
        }
    }

    // Sends the message to the phone
    protected void sendMessageToPhone(String messageStudentId, String messageContent)
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
        Toast.makeText(SendMessageActivity.this, getResources().getString(R.string.sentMessage), Toast.LENGTH_LONG).show();
    }

    // Returns the last coordinates of the wearable
    protected Coordinates getLastCoordinates()
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
