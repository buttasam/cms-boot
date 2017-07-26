package app.admin.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Samuel Butta
 */
public class PageForm {

    @NotNull
    @Size(min=2, max=30)
    private String title;

    @NotNull
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
