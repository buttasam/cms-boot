package app.persistence.entity.eshop;

import app.persistence.entity.cms.PageImage;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel Butta
 */
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Double priceWithVat;

    @Column
    private Double priceWithoutVat;

    @Column
    private String title;

    @Column
    private String perex;

    @Column
    private String description;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages = new ArrayList<>();

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private List<ProductCategory> productCategories = new ArrayList<>();

}
