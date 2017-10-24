package app.persistence.entity.message;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Samuel Butta
 */

@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String message;

    @Column
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;
}