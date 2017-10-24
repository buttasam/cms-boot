package app.persistence.repository.eshop;

import app.persistence.entity.eshop.Order;
import app.persistence.entity.message.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Samuel Butta
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
