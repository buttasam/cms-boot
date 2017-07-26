package app.service.cms;

import app.admin.form.PageForm;
import app.persistence.entity.cms.Page;
import app.persistence.repository.cms.PageImageRepository;
import app.persistence.repository.cms.PageRepository;
import app.persistence.repository.cms.PageTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Samuel Butta
 */
@Service
public class PageService {


    private PageRepository pageRepository;
    private PageImageRepository pageImageRepository;
    private PageTextRepository pageTextRepository;

    @Autowired
    public PageService(PageRepository pageRepository, PageImageRepository pageImageRepository, PageTextRepository pageTextRepository) {
        this.pageRepository = pageRepository;
        this.pageImageRepository = pageImageRepository;
        this.pageTextRepository = pageTextRepository;
    }

    public void savePage(PageForm pageForm) {
        Page page = new Page();
        page.setTitle(pageForm.getTitle());
        page.setUrl(pageForm.getUrl());

        pageRepository.save(page);
    }

}
