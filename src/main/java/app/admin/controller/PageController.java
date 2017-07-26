package app.admin.controller;

import app.admin.form.PageForm;
import app.service.cms.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @author Samuel Butta
 */
@Controller
@RequestMapping("/admin")
public class PageController {


    private PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @RequestMapping("/addPage")
    public String renderDashboard(PageForm pageForm) {
        return "admin/addPage";
    }


    @PostMapping("/addPage")
    public String pageForm(@Valid PageForm pageForm, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            pageService.savePage(pageForm);
        }

        return "redirect:/admin/addPage";
    }

}
