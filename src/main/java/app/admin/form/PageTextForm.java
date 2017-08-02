package app.admin.form;

/**
 * @author Samuel Butta
 */
public class PageTextForm {

    private String identity;

    private String content;

    private Long pageId;

    public PageTextForm() {
    }

    public PageTextForm(String identity, String content, Long pageId) {
        this.identity = identity;
        this.content = content;
        this.pageId = pageId;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }
}
