package app.persistence.entity.eshop;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Samuel Butta
 */
@Entity
@Data
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToOne
    private ProductCategory parentCategory;
}
