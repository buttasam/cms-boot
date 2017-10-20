package app.admin.controller.common;

import app.admin.controller.parent.AdminAbstractController;
import app.config.anotation.AdminController;
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

    private PageRepository pageRepository;

    @Autowired
    public AdminCommonController(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }


    @Value("${buildVersion}")
    private String version;

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        LOG.debug("model attribute method was called");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String loggedUserName = authentication != null ? authentication.getName() : "No user logged in";

        model.addAttribute("version", version);
        model.addAttribute("pages", pageRepository.findByParentPage(null)); // FIXME add wrapp to service method
        model.addAttribute("loggedUserName", loggedUserName);
    }

}
