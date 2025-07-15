package app.common.controller;

import app.admin.controller.parent.AdminAbstractController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Advice controller provides shared data (variables, exception ...).
 */
@ControllerAdvice
@Slf4j
public class CommonAbstractController extends AdminAbstractController {

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        log.debug("model attribute method was called");
    }

}
