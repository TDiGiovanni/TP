package com.dev_mobile_av.wear_tp1;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.dev_mobile_av.shared.Reminder;
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
                    double latitude = map.getDouble("Latitude");
                    double longitude = map.getDouble("Longitude");

                    Reminder reminder = new Reminder("", "", "", "", "");

                    Intent intent = new Intent(this, ShowReminderActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("Reminder", reminder);
                    intent.putExtra("Latitude", latitude);
                    intent.putExtra("Longitude", longitude);
                    startActivity(intent);
                }
            }
        }
    }
}
