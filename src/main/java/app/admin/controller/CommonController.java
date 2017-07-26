package app.admin.controller;

import app.persistence.entity.auth.User;
import app.persistence.repository.cms.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CommonController {

    private PageRepository pageRepository;

    @Autowired
    public CommonController(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        String loggedUserName = SecurityContextHolder.getContext().getAuthentication().getName();

        model.addAttribute("version", "1.0"); // TODO real version number
        model.addAttribute("pages", pageRepository.findAll());
        model.addAttribute("loggedUserName", loggedUserName);
    }

}
