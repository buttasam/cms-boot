package app.persistence.entity.eshop;

import javax.persistence.*;

/**
 * @author Samuel Butta
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
