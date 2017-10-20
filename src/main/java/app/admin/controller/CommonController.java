package app.admin.controller;

import app.persistence.entity.auth.User;
import app.persistence.repository.cms.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Advice controller provides shared data (variables, exception ...).
 *
 * @author Samuel Butta
 */
@ControllerAdvice
public class CommonController extends AdminController {

    private PageRepository pageRepository;

    @Autowired
    public CommonController(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String loggedUserName = authentication != null ? authentication.getName() : "No user logged in";

        model.addAttribute("version", "1.0"); // TODO real version number
        model.addAttribute("pages", pageRepository.findByParentPage(null)); // FIXME add wrapp to service method
        model.addAttribute("loggedUserName", loggedUserName);
    }

}
