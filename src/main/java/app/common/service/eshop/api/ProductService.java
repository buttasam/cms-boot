package app.common.service.eshop.api;

import app.admin.form.ProductForm;
import app.persistence.entity.eshop.Product;

import java.util.List;

/**
 * @author Samuel Butta
 */
public interface ProductService {


    void saveProduct(ProductForm productForm);

    List<Product> findAllProducts();

}
