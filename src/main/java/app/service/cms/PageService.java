package app.service.cms;

import app.persistence.repository.cms.PageImageRepository;
import app.persistence.repository.cms.PageRepository;
import app.persistence.repository.cms.PageTextRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Samuel Butta
 */
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

}
