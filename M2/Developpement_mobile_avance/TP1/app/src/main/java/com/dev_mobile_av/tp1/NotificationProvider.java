package com.dev_mobile_av.tp1;

/**
 * Interface used to create notifications
 */
public interface NotificationProvider
{
    String CHANNEL_ID = "Reminder";
    int notificationId = 0;

    void createNotificationChannel();
    void createNotification(String title, String description);
}