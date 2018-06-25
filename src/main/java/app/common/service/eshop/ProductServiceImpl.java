package app.common.service.eshop;

import app.admin.form.ProductForm;
import app.common.service.eshop.api.ProductService;
import app.persistence.entity.eshop.Product;
import app.persistence.repository.eshop.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Product> productOpt = productRepository.getById(productForm.getProductId());
        Product product = productOpt.orElse(new Product());

        product.setTitle(productForm.getTitle());
        product.setPrice(productForm.getPrice());

        productRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

}
