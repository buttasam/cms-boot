package app.persistence.entity.cms;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Samuel Butta
 */

@Entity
@Data
public class PageText {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String content;

    @Column(unique = true)
    private String identity;

    @ManyToOne
    private Page page;
}
