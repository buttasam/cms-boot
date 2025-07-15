package app.common.service.cms.api;


import app.admin.form.PageForm;
import app.admin.form.PageTextForm;
import app.persistence.entity.cms.Page;
import jakarta.validation.constraints.NotNull;

import java.util.Map;
import java.util.Optional;

/**
 * @author Samuel Butta
 * @author Jakub Tucek
 */
public interface PageService {

    void savePage(PageForm pageForm);

    void savePageText(PageTextForm pageTextForm);

    void updatePageText(@NotNull String identity, @NotNull String content);

    /**
     * Creates a map of text content from a given page.
     * The map uses the identity of each PageText as the key.
     * <p>
     * Example usage:
     * {@code pageTexts.get("welcome-text")}
     *
     * @param pageOptional the optional page containing text content
     * @return a map where keys are identities and values are text content
     */
    Map<String, String> createPageTextsMap(Optional<Page> pageOptional);


    /**
     * Creates a map of image paths from a given page.
     * The map uses the identity of each PageImage as the key.
     *
     * @param pageOptional the optional page containing images
     * @return a map where keys are identities and values are image paths
     */
    Map<String, String> createPageImagesMap(Optional<Page> pageOptional);
}
