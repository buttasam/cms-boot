package app.persistence.entity.message;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
/**
 * @author Samuel Butta
 */

@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String message;

    @Column
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    /**
     * @return true if status of notification is read
     */
    public boolean isRead() {
        return status.equals(NotificationStatus.READ);
    }
}