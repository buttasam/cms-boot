package app.common.service.notification.api;


import app.persistence.entity.message.Notification;

import java.util.List;

/**
 * @author Samuel Butta
 */
public interface NotificationService {

    /**
     * Create new notification
     *
     * @param message text of notification
     */
    void notify(String message);

    /**
     * Notification is marked as read.
     *
     * @param notificationId
     */
    void readNotification(Long notificationId);

    /**
     * Delete notification.
     *
     * @param notificationId
     */
    void deleteNotification(Long notificationId);


    /**
     * @return all notifications with new status
     */
    List<Notification> findNewNotifications();


    /**
     * @return all notifications with new or read
     */
    List<Notification> findActiveNotifications();

}
