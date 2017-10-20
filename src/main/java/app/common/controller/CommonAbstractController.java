package app.common.controller;

import app.admin.controller.parent.AdminAbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Advice controller provides shared data (variables, exception ...).
 *
 * @author Samuel Butta
 */
@ControllerAdvice
public class CommonAbstractController extends AdminAbstractController {


    private static final Logger LOG = LoggerFactory.getLogger(CommonAbstractController.class);


    @ModelAttribute
    public void addCommonAttributes(Model model) {
        LOG.debug("model attribute method was called");
    }

}
