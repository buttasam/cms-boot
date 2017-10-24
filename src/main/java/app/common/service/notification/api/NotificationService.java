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
    public void notify(String message);

    /**
     * Notification is marked as read.
     *
     * @param notificationId
     */
    public void readNotification(Long notificationId);

    /**
     * Delete notification.
     *
     * @param notificationId
     */
    public void deleteNotification(Long notificationId);


    /**
     * @return all notifications with new status
     */
    public List<Notification> findNewNotifications();


    /**
     * @return all notifications with new or read
     */
    public List<Notification> findActiveNotifications();


}
