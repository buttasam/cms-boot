package app.persistence.entity.cms;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Samuel Butta
 */

@Entity
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PageText> getPageTexts() {
        return pageTexts;
    }

    public void setPageTexts(List<PageText> pageTexts) {
        this.pageTexts = pageTexts;
    }

    public List<PageImage> getPageImages() {
        return pageImages;
    }

    public void setPageImages(List<PageImage> pageImages) {
        this.pageImages = pageImages;
    }
}
