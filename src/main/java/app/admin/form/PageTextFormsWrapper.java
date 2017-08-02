package app.admin.form;

import java.util.List;

/**
 * @author Samuel Butta
 */
public class PageTextFormsWrapper {

    private List<PageTextForm> pageTextEditForms;

    public PageTextFormsWrapper(List<PageTextForm> pageTextEditForms) {
        this.pageTextEditForms = pageTextEditForms;
    }

    public List<PageTextForm> getPageTextEditForms() {
        return pageTextEditForms;
    }

    public void setPageTextEditForms(List<PageTextForm> pageTextEditForms) {
        this.pageTextEditForms = pageTextEditForms;
    }
}
