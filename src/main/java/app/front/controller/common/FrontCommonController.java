package app.front.controller.common;

import app.admin.controller.parent.AdminAbstractController;
import app.config.anotation.AdminController;
import app.config.anotation.FrontController;
import app.persistence.repository.cms.PageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Advice controller provides shared data (variables, exception ...) to FrontController components.
 *
 * @author Samuel Butta
 */
@ControllerAdvice(annotations = FrontController.class)
public class FrontCommonController extends AdminAbstractController {

    private static final Logger LOG = LoggerFactory.getLogger(FrontCommonController.class);

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        LOG.debug("model attribute method was called");
    }

}
