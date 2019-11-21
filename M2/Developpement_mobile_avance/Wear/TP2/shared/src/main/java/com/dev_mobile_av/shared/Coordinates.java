package com.dev_mobile_av.shared;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Coordinates implements Serializable
{
    private double latitude;
    private double longitude;

    public Coordinates()
    {
        this.latitude = 0;
        this.longitude = 0;
    }

    public Coordinates(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude()
    {
        return this.latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return this.longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    @Override
    @NonNull
    public String toString()
    {
        String result = "";

        result += "(" + getLatitude() + ", ";
        result += getLongitude() + ")";

        return result;
    }
}
