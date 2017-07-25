package app.persistence.entity.cms;

import javax.persistence.*;

/**
 * @author Samuel Butta
 */

@Entity
public class PageImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
