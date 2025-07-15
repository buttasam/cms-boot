package app.front.controller.common;

import app.admin.controller.parent.AdminAbstractController;
import app.config.anotation.FrontController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Advice controller provides shared data (variables, exception ...) to FrontController components.
 *
 * @author Samuel Butta
 */
@Slf4j
@ControllerAdvice(annotations = FrontController.class)
public class FrontCommonController extends AdminAbstractController {

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        log.debug("model attribute method was called");
    }

}
