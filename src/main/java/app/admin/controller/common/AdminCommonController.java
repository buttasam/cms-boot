package app.admin.controller.common;

import app.admin.controller.parent.AdminAbstractController;
import app.common.service.notification.api.NotificationService;
import app.config.anotation.AdminController;
import app.persistence.entity.auth.Role;
import app.persistence.entity.auth.RoleType;
import app.persistence.entity.auth.User;
import app.persistence.repository.auth.UserRepository;
import app.persistence.repository.cms.PageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Advice controller provides shared data (variables, exception ...) to AdminController components.
 *
 * @author Samuel Butta
 */
@ControllerAdvice(annotations = AdminController.class)
public class AdminCommonController extends AdminAbstractController {

    private static final Logger LOG = LoggerFactory.getLogger(AdminCommonController.class);

    /**
     * Repositories
     */
    private PageRepository pageRepository;


    /**
     * Services
     */
    private NotificationService notificationService;

    @Autowired
    public AdminCommonController(PageRepository pageRepository, NotificationService notificationService) {
        this.pageRepository = pageRepository;
        this.notificationService = notificationService;
    }


    @ModelAttribute
    public void addCommonAttributes(Model model) {
        LOG.debug("model attribute method was called");

        model.addAttribute("version", "0.2-SNAPSHOT");
        model.addAttribute("pages", pageRepository.findByParentPage(null)); // FIXME add wrapp to service method
        model.addAttribute("newNotifications", notificationService.findNewNotifications());
    }

}
