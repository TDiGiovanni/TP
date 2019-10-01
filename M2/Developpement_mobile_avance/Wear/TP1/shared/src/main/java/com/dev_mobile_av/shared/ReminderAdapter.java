package com.dev_mobile_av.shared;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ReminderAdapter extends ArrayAdapter<Reminder>
{
    protected ArrayList<Reminder> reminders;
    protected static LayoutInflater inflater = null;

    public ReminderAdapter (Activity activity, int textViewResourceId, ArrayList<Reminder> reminders)
    {
        super(activity, textViewResourceId, reminders);

        try
        {
            this.reminders = reminders;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public int getCount()
    {
        return reminders.size();
    }

    public Reminder getItem(int position)
    {
        return reminders.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    public static class ViewHolder
    {
        protected TextView display_title;
        protected TextView display_date;
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
                view = inflater.inflate(R.layout.reminder_item, null);
                holder = new ViewHolder();

                holder.display_title = view.findViewById(R.id.reminderTitle);
                holder.display_date = view.findViewById(R.id.reminderDate);

                view.setTag(holder);
            }
            else {
                holder = (ViewHolder) view.getTag();
            }

            holder.display_title.setText(reminders.get(position).title);
            holder.display_date.setText(reminders.get(position).getFullDate());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return view;
    }
}