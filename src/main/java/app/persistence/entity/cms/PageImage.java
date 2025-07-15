package app.persistence.entity.cms;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
/**
 * @author Samuel Butta
 */

@Entity
@Data
public class PageImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Page page;

    @Column
    private String fileName;

    @Column(unique = true)
    private String identity;

    @Column
    private String path;
}
