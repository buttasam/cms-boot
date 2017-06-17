package app.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Samuel Butta
 */
@Controller
@RequestMapping("/admin")
public class DashboardController {

    @RequestMapping
    public String renderIndex() {
        return "redirect:/admin/dashboard";
    }

    @RequestMapping("/dashboard")
    public String renderDashboard() {
        return "admin/dashboard";
    }

}
