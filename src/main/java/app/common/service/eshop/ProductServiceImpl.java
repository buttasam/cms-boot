package app.common.service.eshop;

import app.admin.form.ProductForm;
import app.common.service.eshop.api.ProductService;
import app.persistence.entity.eshop.Product;
import app.persistence.repository.eshop.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Samuel Butta
 */
@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(ProductForm productForm) {
        Product product = new Product();
        product.setTitle(productForm.getTitle());
        product.setPerex(productForm.getPerex());
        product.setPriceWithVat(productForm.getPriceWithVat());
        product.setPriceWithoutVat(productForm.getPriceWithoutVat());

        productRepository.save(product);
    }

}
