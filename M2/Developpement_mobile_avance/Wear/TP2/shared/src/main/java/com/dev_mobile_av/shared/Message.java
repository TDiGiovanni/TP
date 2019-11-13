package com.dev_mobile_av.shared;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Message implements Serializable
{
    private String content;
    private double latitude;
    private double longitude;

    public Message(String content, float latitude, float longitude)
    {
        this.content = content;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getContent()
    {
        return this.content;
    }

    public double getLatitude()
    {
        return this.latitude;
    }

    public double getLongitude()
    {
        return this.longitude;
    }

    @NonNull
    public String toString()
    {
        String result = "";

        result += "(" + latitude
                + " - " + longitude + ")"
                + ": " + content;

        return result;
    }
}
