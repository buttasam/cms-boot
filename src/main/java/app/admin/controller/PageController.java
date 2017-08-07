package app.admin.controller;

import app.admin.form.PageForm;
import app.admin.form.PageTextForm;
import app.persistence.entity.cms.Page;
import app.persistence.repository.cms.PageRepository;
import app.persistence.repository.cms.PageTextRepository;
import app.service.cms.api.PageService;
import app.service.cms.api.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
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
    private StorageService storageService;

    /**
     * Repositories
     */
    private PageRepository pageRepository;
    private PageTextRepository pageTextRepository;

    @Autowired
    public PageController(PageService pageService, StorageService storageService, PageRepository pageRepository, PageTextRepository pageTextRepository) {
        this.pageService = pageService;
        this.storageService = storageService;
        this.pageRepository = pageRepository;
        this.pageTextRepository = pageTextRepository;
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
    public String pageTextForm(@Valid PageTextForm pageTextForm, BindingResult bindingResult, HttpServletRequest httpRequest) {

        pageService.savePageText(pageTextForm);

        return "redirect:/admin/addPage";
    }

    @PostMapping("/page/editPageText")
    public String pageTextEditForm(@RequestParam String content,@RequestParam String identity,@RequestParam Long pageId) {
        pageService.updatePageText(identity, content);
        Page page = pageRepository.findOne(pageId);

        return "redirect:/admin/page/" + page.getUrl();
    }


    @RequestMapping(value = "/page/{url}")
    public String renderPage(@PathVariable("url") String url, Model model) {

        // TODO osetrit pokud neexistuje
        Optional<Page> pageOptional = pageRepository.getByUrl(url);

        if (pageOptional.isPresent()) {
            Page page = pageOptional.get();

        PageTextForm pageTextForm = new PageTextForm();
        pageTextForm.setPageId(page.getId());

        List<PageTextForm> pageTextEditForms = page.getPageTexts()
                .stream()
                .map(p -> PageTextForm.builder()
                        .identity(p.getIdentity())
                        .content(p.getContent())
                        .pageId(p.getPage().getId())
                        .build())
                .collect(Collectors.toList());

        model.addAttribute("page", pageOptional.get());
        model.addAttribute("pageTextForm", pageTextForm);

        }
        return "admin/page";
    }


    @PostMapping("/addPageImage")
    public String addPageImage(@RequestParam("file") MultipartFile file,
                               @RequestParam("identity") String identity,
                               @RequestParam("pageId") Long pageId) {
        Page page = pageRepository.findOne(pageId);
        storageService.store(file, page);

        return "redirect:/admin/page/" + page.getUrl();
    }


    @GetMapping("/files/{fileName:.+}")
    public ResponseEntity<Resource> serveFile(@PathVariable String fileName) {
        Resource file = storageService.loadAsResource(fileName);

        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }


}
