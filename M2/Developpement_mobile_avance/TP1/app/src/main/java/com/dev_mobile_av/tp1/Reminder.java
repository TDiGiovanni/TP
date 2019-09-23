package com.dev_mobile_av.tp1;

public class Reminder
{
    protected String time;
    protected String date;
    protected String type;
    protected String title;
    protected String description;

    public Reminder(String time, String date, String type, String title, String description)
    {
        this.time = time;
        this.date = date;
        this.type = type;
        this.title = title;
        this.description = description;
    }

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
