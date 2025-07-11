package app.front.controller.common;

import app.admin.controller.parent.AdminAbstractController;
import app.config.anotation.FrontController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
