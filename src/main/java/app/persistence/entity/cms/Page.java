package app.persistence.entity.cms;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel Butta
 */

@Entity
@Data
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column(unique = true)
    private String url;

    @OneToMany(mappedBy = "page")
    private List<PageText> pageTexts = new ArrayList<>();

    @OneToMany(mappedBy = "page")
    private List<PageImage> pageImages = new ArrayList<>();

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="parent_page_id")
    private Page parentPage;

    @OneToMany(mappedBy = "parentPage")
    private List<Page> subPages;
}