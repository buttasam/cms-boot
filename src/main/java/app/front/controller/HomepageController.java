package app.front.controller;

import app.config.anotation.FrontController;
import app.front.controller.parent.FrontAbstractController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Samuel Butta
 */
@FrontController
public class HomepageController extends FrontAbstractController {


    @RequestMapping("/")
    public String index(Model model) {
        addPageData(model, "homepage");

        return "front/index";
    }

}
