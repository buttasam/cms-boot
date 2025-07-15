package app.common.service.cms;

import app.admin.form.PageForm;
import app.admin.form.PageTextForm;
import app.common.service.cms.api.PageService;
import app.persistence.entity.cms.Page;
import app.persistence.entity.cms.PageImage;
import app.persistence.entity.cms.PageText;
import app.persistence.repository.cms.PageRepository;
import app.persistence.repository.cms.PageTextRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Samuel Butta
 */
@Service
class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;
    private final PageTextRepository pageTextRepository;

    @Autowired
    public PageServiceImpl(PageRepository pageRepository, PageTextRepository pageTextRepository) {
        this.pageRepository = pageRepository;
        this.pageTextRepository = pageTextRepository;
    }

    @Override
    public void savePage(PageForm pageForm) {
        Page page = new Page();
        page.setTitle(pageForm.getTitle());
        page.setUrl(pageForm.getUrl());

        Long parentPageId = pageForm.getParentPageId();

        Page parentPage = null;
        if (parentPageId != null) {
            parentPage = pageRepository.getReferenceById(pageForm.getParentPageId());

            List<Page> subPages = parentPage.getSubPages();
            subPages.add(page);

            parentPage.setSubPages(subPages);
            pageRepository.save(parentPage);
        }
        page.setParentPage(parentPage);

        pageRepository.save(page);
    }

    @Override
    public void savePageText(PageTextForm pageTextForm) {
        PageText pageText = new PageText();
        Page page = pageRepository.getReferenceById(pageTextForm.getPageId());

        pageText.setIdentity(pageTextForm.getIdentity());
        pageText.setContent(pageTextForm.getContent());
        pageText.setType(pageTextForm.getType());
        pageText.setPage(page);

        pageTextRepository.save(pageText);
    }

    @Override
    public void updatePageText(@NotNull String identity, @NotNull String content) {
        pageTextRepository.findByIdentity(identity).ifPresentOrElse(pageText -> {
            pageText.setContent(content);
            pageTextRepository.save(pageText);
        }, () -> {
            throw new EntityNotFoundException("PageText with identity '" + identity + "' not found.");
        });
    }

    @Override
    public Map<String, String> createPageTextsMap(Optional<Page> pageOptional) {
        return pageOptional
                .map(this::mapPage)
                .orElseGet(Collections::emptyMap);
    }

    @Override
    public Map<String, String> createPageImagesMap(Optional<Page> pageOpt) {
        return pageOpt
                .map(this::mapPageImage)
                .orElseGet(Collections::emptyMap);
    }

    private Map<String, String> mapPage(Page page) {
        return page.getPageTexts()
                .stream()
                .collect(Collectors.toMap(PageText::getIdentity, PageText::getContent));
    }

    private Map<String, String> mapPageImage(Page page) {
        return page.getPageImages()
                .stream()
                .collect(Collectors.toMap(PageImage::getIdentity, PageImage::getFileName));
    }

}
