package app.common.service.cms.api;

import app.admin.form.PageForm;
import app.admin.form.PageTextForm;
import app.persistence.entity.cms.Page;
import app.persistence.entity.cms.PageText;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Optional;

/**
 * @author Jakub Tucek
 */
public interface PageService {
    void savePage(PageForm pageForm);

    void savePageText(PageTextForm pageTextForm);

    void updatePageText(@NotNull String identity, @NotNull String content);

    Map<String, String> createPageTextsMap(Optional<Page> pageOptional);
}
