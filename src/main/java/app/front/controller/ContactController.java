package app.front.controller;

import app.config.anotation.FrontController;
import app.front.controller.parent.FrontAbstractController;
import app.front.form.OrderForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author Samuel Butta
 */

@FrontController
public class ContactController extends FrontAbstractController {

    Logger LOG = LoggerFactory.getLogger(ContactController.class);

    @RequestMapping(value = "/kontakty")
    public String order() {
        return "front/contact";
    }

}
