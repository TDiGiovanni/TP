package com.dev_mobile_av.wear_tp2;

import android.content.Intent;

import com.dev_mobile_av.shared.Message;
import com.dev_mobile_av.shared.ServerTask;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.WearableListenerService;

import org.json.JSONObject;

import java.util.Objects;

public class WearListenerService extends WearableListenerService
{
    @Override
    public void onDataChanged(DataEventBuffer dataEvents)
    {
        super.onDataChanged(dataEvents);

        for (DataEvent event : dataEvents)
        {
            if (event.getType() == DataEvent.TYPE_CHANGED)
            {
                DataMap map = DataMapItem.fromDataItem(event.getDataItem()).getDataMap();
                String path = event.getDataItem().getUri().getPath();

                if (Objects.requireNonNull(path).equals("/Message"))
                {
                    Message message = new Message(map.getString("StudentId"),
                            map.getString("Content"),
                            map.getDouble("Latitude"),
                            map.getDouble("Longitude"));

                    String serverUri = "https://hmin309-embedded-systems.herokuapp.com/message-exchange/messages/";
                    ServerTask serverTask = new ServerTask(serverUri, true, this);
                    serverTask.execute(message.getStudentId(),
                            message.getContent(),
                            Double.toString(message.getLatitude()),
                            Double.toString(message.getLongitude()));
                }
            }
        }
    }
}
