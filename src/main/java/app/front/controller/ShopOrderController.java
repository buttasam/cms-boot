package app.front.controller;

import app.common.service.notification.api.NotificationService;
import app.config.anotation.FrontController;
import app.front.controller.parent.FrontAbstractController;
import app.front.form.OrderForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author Samuel Butta
 */

@FrontController
public class ShopOrderController extends FrontAbstractController {

    private NotificationService notificationService;

    @Autowired
    public ShopOrderController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    Logger LOG = LoggerFactory.getLogger(ShopOrderController.class);

    @RequestMapping(value = "/objednavka")
    public String order(OrderForm orderForm) {

        return "front/order";
    }

    @PostMapping(value = "/order/send")
    public String sendOrder(@Valid OrderForm orderForm, BindingResult bindingResult) {
        LOG.info("order form was send with data {}", orderForm);

        // TODO save to database

        // TODO send email
;
        // TODO save to notifications
        notificationService.notify("new order sended");

        return redirect("/objednavka");
    }

}
