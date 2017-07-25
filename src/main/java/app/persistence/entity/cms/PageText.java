package app.persistence.entity.cms;

import javax.persistence.*;

/**
 * @author Samuel Butta
 */

@Entity
public class PageText {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
