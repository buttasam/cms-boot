package app.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Samuel Butta
 */

@Controller
@RequestMapping("/admin/shop")
public class ShopController extends AdminController {


    @RequestMapping("/productCategory")
    public String productCategory(@RequestParam(required = false) Long parentProductCategoryId) {

        return "admin/productCategory";
    }


}
