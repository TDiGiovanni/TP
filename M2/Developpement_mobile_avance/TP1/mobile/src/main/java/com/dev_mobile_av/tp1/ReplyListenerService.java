package com.dev_mobile_av.tp1;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.WearableListenerService;

public class ReplyListenerService extends WearableListenerService
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
                if (path.equals("/Reply"))
                {
                    String reply = map.getString("Reply");
                }
            }
        }
    }
}
