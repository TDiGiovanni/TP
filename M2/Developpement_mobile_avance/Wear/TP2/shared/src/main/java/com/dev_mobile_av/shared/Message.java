package com.dev_mobile_av.shared;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Message implements Serializable
{
    private String time;
    private String date;
    private String title;
    private String description;

    public Message(String time, String date, String title, String content)
    {
        this.time = time;
        this.date = date;
        this.title = title;
        this.description = content;
    }

    public String getFullDate()
    {
        return this.date + " - " + this.time;
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
                + " - " + description;

        return result;
    }
}
