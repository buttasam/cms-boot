package app.admin.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Advice controller provides shared data (variables, exception ...).
 *
 * @author Samuel Butta
 */
@ControllerAdvice
public class CommonController {

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        model.addAttribute("version", "1.0"); // TODO real version number
    }

}
