package app.persistence.repository.message;

import app.persistence.entity.message.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Samuel Butta
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
