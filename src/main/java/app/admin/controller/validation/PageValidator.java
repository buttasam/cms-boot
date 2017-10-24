package app.admin.controller.validation;

import app.admin.form.PageForm;
import app.persistence.repository.cms.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Samuel Butta
 */
@Service
public class PageValidator {

    private PageRepository pageRepository;

    @Autowired
    public PageValidator(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    /**
     * @param pageForm form object
     * @return true if page can be added
     */
    public boolean isAddPageValid(PageForm pageForm) {
        boolean isValid = !pageRepository.getByUrl(pageForm.getUrl()).isPresent();

        return isValid;
    }

}
