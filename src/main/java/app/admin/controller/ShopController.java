package app.admin.controller;

import app.admin.controller.parent.AdminAbstractController;
import app.config.anotation.AdminController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Samuel Butta
 */

@AdminController
@RequestMapping("/admin/shop")
public class ShopController extends AdminAbstractController {


    @RequestMapping("/productCategory")
    public String productCategory(@RequestParam(required = false) Long parentProductCategoryId) {

        return "admin/productCategory";
    }


}
