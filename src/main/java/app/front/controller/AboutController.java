package app.front.controller;

import app.config.anotation.FrontController;
import app.front.controller.parent.FrontAbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Samuel Butta
 */
@FrontController
public class AboutController extends FrontAbstractController {

    @RequestMapping(value = {"o-nas", "/about"})
    public String about() {

        return "front/about";
    }
}
