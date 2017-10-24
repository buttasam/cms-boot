package app.admin.controller.validation;

import app.admin.form.PageTextForm;
import app.persistence.repository.cms.PageTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Samuel Butta
 */
@Service
public class PageTextValidator {

    private PageTextRepository pageTextRepository;

    @Autowired
    public PageTextValidator(PageTextRepository pageTextRepository) {
        this.pageTextRepository = pageTextRepository;
    }

    /**
     * @param pageTextForm form object
     * @return true if page text can be added
     */
    public boolean isAddPageTextValid(PageTextForm pageTextForm) {
        boolean isValid = !pageTextRepository.findByIdentity(pageTextForm.getIdentity()).isPresent();

        return isValid;
    }

}
