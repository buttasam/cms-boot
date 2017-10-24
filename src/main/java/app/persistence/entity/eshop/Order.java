package app.persistence.entity.eshop;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Samuel Butta
 */

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;
}