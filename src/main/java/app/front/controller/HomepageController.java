package app.front.controller;

import app.common.service.cms.api.PageService;
import app.config.anotation.FrontController;
import app.front.controller.parent.FrontAbstractController;
import app.persistence.entity.cms.Page;
import app.persistence.repository.cms.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Optional;

/**
 * @author Samuel Butta
 */
@FrontController
public class HomepageController extends FrontAbstractController {


    /**
     * Repositories
     */
    private PageRepository pageRepository;

    /**
     * Services
     */
    private PageService pageService;

    @Autowired
    public HomepageController(PageRepository pageRepository, PageService pageService) {
        this.pageRepository = pageRepository;
        this.pageService = pageService;
    }


    @RequestMapping("/")
    public String index(Model model) {
        Optional<Page> pageOpt = pageRepository.getByUrl("homepage");
        Map<String, String> pageTexts = pageService.createPageTextsMap(pageOpt);
        model.addAttribute("pageTexts", pageTexts);

        return "front/index";
    }

}
