package app.persistence.repository.message;

import app.persistence.entity.message.Notification;
import app.persistence.entity.message.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Samuel Butta
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findAllByStatus(NotificationStatus notificationStatus);

    List<Notification> findAllByStatusNot(NotificationStatus notificationStatus);

}
