package app.front.controller;

import app.config.anotation.FrontController;
import app.front.controller.parent.FrontAbstractController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Samuel Butta
 */
@FrontController
public class AboutController extends FrontAbstractController {

    @RequestMapping(value = {"/about"})
    public String about(Model model) {
        addPageData(model, "about");
        return "front/about";
    }
}
