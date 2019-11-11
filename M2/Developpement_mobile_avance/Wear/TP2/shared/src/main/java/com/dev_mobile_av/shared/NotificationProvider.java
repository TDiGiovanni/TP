package com.dev_mobile_av.shared;

/**
 * Interface used to create notifications
 */
public interface NotificationProvider
{
    String CHANNEL_ID = "WearTP2Notification";
    int notificationId = 0;

    void createNotificationChannel();
    void createNotification(Message message);
}