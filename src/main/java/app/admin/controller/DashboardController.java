package app.admin.controller;

import app.admin.controller.parent.AdminAbstractController;
import app.config.anotation.AdminController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Samuel Butta
 */
@AdminController
@RequestMapping("/admin")
public class DashboardController extends AdminAbstractController {

    @RequestMapping
    public String renderIndex() {
        return redirect("/admin/dashboard");
    }

    @RequestMapping("/dashboard")
    public String renderDashboard() {
        return "admin/dashboard";
    }

}
