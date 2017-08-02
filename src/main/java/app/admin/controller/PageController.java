package app.admin.controller;

import app.admin.form.PageForm;
import app.admin.form.PageTextForm;
import app.admin.form.PageTextFormsWrapper;
import app.persistence.entity.cms.Page;
import app.persistence.repository.cms.PageRepository;
import app.service.cms.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Samuel Butta
 */
@Controller
@RequestMapping("/admin")
public class PageController {


    /**
     * Services
     */
    private PageService pageService;


    /**
     * Repositories
     */
    private PageRepository pageRepository;

    @Autowired
    public PageController(PageService pageService, PageRepository pageRepository) {
        this.pageService = pageService;
        this.pageRepository = pageRepository;
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

    @PostMapping("/page")
    public String pageTextForm(@Valid PageTextForm pageTextForm, BindingResult bindingResult) {

        pageService.savePageText(pageTextForm);

        return "redirect:/admin/addPage";
    }


    @RequestMapping(value = "/page/{url}")
    public String renderPage(@PathVariable("url") String url, Model model) {

        // TODO osetrit pokud neexistuje
        Page page = pageRepository.findByUrl(url);

        PageTextForm pageTextForm = new PageTextForm();
        pageTextForm.setPageId(page.getId());

        List<PageTextForm> pageTextEditForms = page.getPageTexts()
                .stream()
                .map(p -> new PageTextForm(p.getIdentity(), p.getContent(), p.getPage().getId()))
                .collect(Collectors.toList());

        model.addAttribute("page", page);
        model.addAttribute("pageTextForm", pageTextForm);
        model.addAttribute("wrapper", new PageTextFormsWrapper(pageTextEditForms));

        return "admin/page";
    }

}
