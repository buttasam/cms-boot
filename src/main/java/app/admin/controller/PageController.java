package app.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Samuel Butta
 */
@Controller
@RequestMapping("/admin")
public class PageController {

    @RequestMapping("/addPage")
    public String renderDashboard() {
        return "admin/addPage";
    }

}
