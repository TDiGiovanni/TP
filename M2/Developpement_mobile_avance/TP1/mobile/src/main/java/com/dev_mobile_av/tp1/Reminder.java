package com.dev_mobile_av.tp1;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Reminder implements Serializable
{
    protected String time;
    protected String date;
    protected ReminderType type;
    protected String title;
    protected String description;

    public Reminder(String time, String date, ReminderType type, String title, String description)
    {
        this.time = time;
        this.date = date;
        this.type = type;
        this.title = title;
        this.description = description;
    }

    public Reminder(String time, String date, String type, String title, String description)
    {
        this.time = time;
        this.date = date;

        if (type.equals("Message"))
            this.type = ReminderType.Message;
        else if (type.equals("Media"))
            this.type = ReminderType.Media;

        this.title = title;
        this.description = description;
    }

    public String getFullDate()
    {
        return this.date + " - " + this.time;
    }

    @NonNull
    public String toString()
    {
        String result = "";

        result += title
                + " - " + date
                + " - " + time
                + " - " + type
                + " - " + description;

        return result;
    }
}
