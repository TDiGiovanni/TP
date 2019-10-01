package com.dev_mobile_av.shared;

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
        this.type = ReminderType.valueOf(type);
        this.title = title;
        this.description = description;
    }

    public String getFullDate()
    {
        return this.date + " - " + this.time;
    }

    public ReminderType getType()
    {
        return this.type;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getDescription()
    {
        return this.description;
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
