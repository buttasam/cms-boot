package app.persistence.entity.cms;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel Butta
 */

@Entity
@Data
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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