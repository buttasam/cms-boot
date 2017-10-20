package app.admin.controller;


import app.admin.form.ProductForm;
import app.common.service.eshop.api.ProductService;
import app.persistence.repository.eshop.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author Samuel Butta
 */

@Controller
@RequestMapping("/admin/product")
public class ProductController extends AdminController {


    private ProductService productService;

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }


    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("products", productRepository.findAll());

        return "admin/product/all";
    }


    @RequestMapping("/addProduct")
    public String addProduct(ProductForm productForm, Model model) {
        return "admin/addProduct";
    }


    @PostMapping("/addProduct")
    public String productForm(@Valid ProductForm productForm, BindingResult bindingResult) {

        if(!bindingResult.hasErrors()) {
            productService.saveProduct(productForm);
        }

        return redirect("admin/product/all");
    }

}
