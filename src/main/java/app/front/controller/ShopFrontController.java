package app.front.controller;

import app.common.service.notification.api.NotificationService;
import app.config.anotation.FrontController;
import app.front.controller.parent.FrontAbstractController;
import app.front.form.OrderForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Samuel Butta
 */

@FrontController
public class ShopFrontController extends FrontAbstractController {


    @RequestMapping(value = "/products")
    public String order() {
        return "front/products";
    }

}
