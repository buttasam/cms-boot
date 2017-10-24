package app.admin.controller;

import app.admin.controller.parent.AdminAbstractController;
import app.common.service.notification.api.NotificationService;
import app.config.anotation.AdminController;
import app.persistence.repository.message.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Samuel Butta
 */
@AdminController
@RequestMapping("/admin")
public class NotificationController extends AdminAbstractController {


    private NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping("/notification")
    public String renderIndex(Model model) {
        model.addAttribute("notifications", notificationService.findActiveNotifications());
        return "admin/notification";
    }

    @RequestMapping("/notification/read")
    public String readNotification(@RequestParam Long notificationId) {
        notificationService.readNotification(notificationId);
        return redirect("/admin/notification");
    }

    @RequestMapping("/notification/delete")
    public String deleteNotification(@RequestParam Long notificationId) {
        notificationService.deleteNotification(notificationId);
        return redirect("/admin/notification");
    }

}
