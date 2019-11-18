package com.dev_mobile_av.shared;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MessageAdapter extends ArrayAdapter<Message>
{
    private List<Message> messages;
    private static LayoutInflater inflater = null;

    public MessageAdapter(Activity activity, int textViewResourceId, List<Message> messages)
    {
        super(activity, textViewResourceId, messages);

        try
        {
            this.messages = messages;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public int getCount()
    {
        return messages.size();
    }

    public Message getItem(int position)
    {
        return messages.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    public static class ViewHolder
    {
        TextView contentDisplay;
        TextView coordinatesDisplay;
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        View view = convertView;
        final ViewHolder holder;

        try
        {
            if (convertView == null)
            {
                view = inflater.inflate(R.layout.message_item, parent, false);
                holder = new ViewHolder();

                holder.contentDisplay = view.findViewById(R.id.messageContent);
                holder.coordinatesDisplay = view.findViewById(R.id.messageCoordinates);

                view.setTag(holder);
            }
            else {
                holder = (ViewHolder) view.getTag();
            }

            holder.contentDisplay.setText(messages.get(position).getContent());
            holder.coordinatesDisplay.setText(messages.get(position).getCoordinates().toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return view;
    }
}