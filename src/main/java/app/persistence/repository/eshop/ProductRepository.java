package app.persistence.repository.eshop;

import app.persistence.entity.eshop.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Samuel Butta
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public Optional<Product> getById(Long productId);

}
