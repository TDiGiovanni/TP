package com.dev_mobile_av.wear_tp2;

import android.content.Intent;

import com.dev_mobile_av.shared.Message;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.WearableListenerService;

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

                if (Objects.requireNonNull(path).equals("/Coordinates"))
                {
                    Message message = new Message("", map.getDouble("Latitude"), map.getDouble("Longitude"));

                    Intent intent = new Intent(this, SendMessageActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("Message", message);
                    startActivity(intent);
                }
            }
        }
    }
}
