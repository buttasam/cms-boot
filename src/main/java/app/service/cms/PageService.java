package app.service.cms;

import app.admin.form.PageForm;
import app.admin.form.PageTextForm;
import app.persistence.entity.cms.Page;
import app.persistence.entity.cms.PageText;
import app.persistence.repository.cms.PageImageRepository;
import app.persistence.repository.cms.PageRepository;
import app.persistence.repository.cms.PageTextRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author Samuel Butta
 */
@Service
public class PageService {


    private final PageRepository pageRepository;
    private final PageImageRepository pageImageRepository;
    private final PageTextRepository pageTextRepository;

    @Autowired
    public PageService(PageRepository pageRepository, PageImageRepository pageImageRepository, PageTextRepository pageTextRepository) {
        this.pageRepository = pageRepository;
        this.pageImageRepository = pageImageRepository;
        this.pageTextRepository = pageTextRepository;
    }

    // FIXME osetreni
    public void savePage(PageForm pageForm) {
        Page page = new Page();
        page.setTitle(pageForm.getTitle());
        page.setUrl(pageForm.getUrl());

        pageRepository.save(page);
    }

    public void savePageText(PageTextForm pageTextForm) {
        PageText pageText = new PageText();

        Page page = pageRepository.getOne(pageTextForm.getPageId());

        pageText.setIdentity(pageTextForm.getIdentity());
        pageText.setContent(pageTextForm.getContent());
        pageText.setPage(page);

        pageTextRepository.save(pageText);
    }

    public void updatePageText(@NotNull String identity, @NotNull String content) {
        PageText pageText = pageTextRepository.findByIdentity(identity);
        pageText.setContent(content);

        pageTextRepository.save(pageText);
    }
}
