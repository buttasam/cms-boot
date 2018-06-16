package app.admin.controller;

import app.admin.controller.parent.AdminAbstractController;
import app.admin.controller.validation.PageTextValidator;
import app.admin.controller.validation.PageValidator;
import app.admin.form.PageForm;
import app.admin.form.PageTextForm;
import app.common.service.cms.api.PageService;
import app.common.service.cms.api.StorageService;
import app.config.anotation.AdminController;
import app.persistence.entity.cms.Page;
import app.persistence.repository.cms.PageRepository;
import app.persistence.repository.cms.PageTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Samuel Butta
 */
@AdminController
@RequestMapping("/admin")
public class PageController extends AdminAbstractController {


    /**
     * Services
     */
    private PageService pageService;
    private StorageService storageService;

    /**
     * Repositories
     */
    private PageRepository pageRepository;
    private PageTextRepository pageTextRepository;

    /**
     * Validators
     */
    private PageValidator pageValidator;
    private PageTextValidator pageTextValidator;

    @Autowired
    public PageController(PageService pageService, StorageService storageService, PageRepository pageRepository, PageTextRepository pageTextRepository, PageValidator pageValidator, PageTextValidator pageTextValidator) {
        this.pageService = pageService;
        this.storageService = storageService;
        this.pageRepository = pageRepository;
        this.pageTextRepository = pageTextRepository;
        this.pageValidator = pageValidator;
        this.pageTextValidator = pageTextValidator;
    }


    @RequestMapping("/addPage")
    public String addPage(@RequestParam(required = false) Long parentPageId, PageForm pageForm, Model model) {
        model.addAttribute("parentPageId", parentPageId);

        return "admin/addPage";
    }


    @PreAuthorize("hasRole('DEVELOPER')")
    @PostMapping("/addPage")
    public String pageForm(@Valid PageForm pageForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !pageValidator.isAddPageValid(pageForm)) {
            return "admin/addPage";
        }
        pageService.savePage(pageForm);

        redirectAttributes.addAttribute("pageUrl", pageForm.getUrl());
        return redirect("/admin/page/{pageUrl}");
    }

    @PreAuthorize("hasRole('DEVELOPER')")
    @PostMapping("/page/addPageText")
    public String pageTextForm(@Valid PageTextForm pageTextForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        Page page = pageRepository.getOne(pageTextForm.getPageId());
        if (bindingResult.hasErrors() || !pageTextValidator.isAddPageTextValid(pageTextForm)) {
            model.addAttribute("page",page);
            return "admin/page";
        }
        pageService.savePageText(pageTextForm);

        redirectAttributes.addAttribute("pageUrl", page.getUrl());
        return redirect("/admin/page/{pageUrl}");
    }

    @PostMapping("/page/editPageText")
    public String pageTextEditForm(@RequestParam String content, @RequestParam String identity, @RequestParam Long pageId, RedirectAttributes redirectAttributes) {
        pageService.updatePageText(identity, content);
        Page page = pageRepository.getOne(pageId);

        redirectAttributes.addAttribute("pageUrl", page.getUrl());
        return redirect("/admin/page/{pageUrl}");
    }


    @RequestMapping(value = "/page/{url}")
    public String renderPage(@PathVariable("url") String url, Model model) {
        Optional<Page> pageOptional = pageRepository.getByUrl(url);

        if (pageOptional.isPresent()) {
            Page page = pageOptional.get();

            PageTextForm pageTextForm = new PageTextForm();
            pageTextForm.setPageId(page.getId());

            model.addAttribute("page", pageOptional.get());
            model.addAttribute("pageTextForm", pageTextForm);

            return "admin/page";
        } else {
            return redirect("/admin/dashboard");
        }
    }


    @PostMapping("/addPageImage")
    public String addPageImage(@RequestParam("file") MultipartFile file,
                               @RequestParam("identity") String identity,
                               @RequestParam("pageId") Long pageId,
                               RedirectAttributes redirectAttributes) {
        Page page = pageRepository.getOne(pageId);
        storageService.store(file, identity, page);

        redirectAttributes.addAttribute("pageUrl", page.getUrl());
        return redirect("/admin/page/{pageUrl}");
    }

}
