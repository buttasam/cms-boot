package app.common.service.notification;

import app.common.service.notification.api.NotificationService;
import app.persistence.entity.message.Notification;
import app.persistence.entity.message.NotificationStatus;
import app.persistence.repository.message.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Samuel Butta
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    private NotificationRepository notificationRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void notify(String message) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setStatus(NotificationStatus.NEW);

        notificationRepository.save(notification);
    }

    @Override
    public void readNotification(Notification notification) {
        notification.setStatus(NotificationStatus.READ);
        notificationRepository.save(notification);
    }

    @Override
    public void deleteNotification(Notification notification) {
        notification.setStatus(NotificationStatus.DELETED);
        notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findNewNotifications() {
        return notificationRepository.findAllByStatus(NotificationStatus.NEW);
    }

    @Override
    public List<Notification> findActiveNotifications() {
        return notificationRepository.findAllByStatusNot(NotificationStatus.DELETED);
    }
}
