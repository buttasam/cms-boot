package app.admin.controller;

import app.admin.form.PageForm;
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

    @RequestMapping("/addPage")
    public String renderDashboard(PageForm pageForm) {
        return "admin/addPage";
    }


    @PostMapping("/addPage")
    public String pageForm(@Valid PageForm pageForm, BindingResult bindingResult) {

        if(!bindingResult.hasErrors()) {
            System.out.println(pageForm.getTitle());
        }

        return "redirect:/admin/addPage";
    }

}
