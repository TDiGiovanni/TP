package com.dev_mobile_av.shared;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Message implements Serializable
{
    private String studentId;
    private String content;
    private Coordinates coordinates;

    public Message(String studentId, String content, Coordinates coordinates)
    {
        this.studentId = studentId;
        this.content = content;
        this.coordinates = coordinates;
    }

    public String getStudentId()
    {
        return studentId;
    }

    public String getContent()
    {
        return this.content;
    }

    public Coordinates getCoordinates()
    {
        return this.coordinates;
    }

    @NonNull
    public String toString()
    {
        String result = getStudentId() + ": ";

        result += "(" + coordinates.getLatitude()
                + " - " + coordinates.getLongitude() + ")"
                + ": " + getContent();

        return result;
    }
}
