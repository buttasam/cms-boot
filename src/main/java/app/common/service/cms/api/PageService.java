package app.common.service.cms.api;

import app.admin.form.PageForm;
import app.admin.form.PageTextForm;

import javax.validation.constraints.NotNull;

/**
 * @author Jakub Tucek
 */
public interface PageService {
    void savePage(PageForm pageForm);

    void savePageText(PageTextForm pageTextForm);

    void updatePageText(@NotNull String identity, @NotNull String content);
}
