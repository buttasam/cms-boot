package app.persistence.entity.eshop;

import app.persistence.entity.cms.Page;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Samuel Butta
 */
@Entity
@Data
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Product product;

    @Column
    private String fileName;

    @Column
    private String path;

}
