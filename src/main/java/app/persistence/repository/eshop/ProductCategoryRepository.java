package app.persistence.repository.eshop;

import app.persistence.entity.eshop.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Samuel Butta
 */
@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

    List<ProductCategory> findByParentCategory(ProductCategory pareProductCategory);

}
