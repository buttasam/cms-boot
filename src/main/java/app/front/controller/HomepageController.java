package app.front.controller;

import app.config.anotation.FrontController;
import app.front.controller.parent.FrontAbstractController;
import app.persistence.entity.cms.Page;
import app.persistence.entity.cms.PageText;
import app.persistence.repository.cms.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Samuel Butta
 */
@FrontController
public class HomepageController extends FrontAbstractController {


    private PageRepository pageRepository;

    @Autowired
    public HomepageController(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }


    // TODO remove to service
    private static Map<String, String> mapPage(Page page) {
        return page.getPageTexts()
                .stream()
                .collect(Collectors.toMap(PageText::getIdentity, PageText::getContent));
    }

    @RequestMapping("/")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
                           Model model) {

        Optional<Page> page = pageRepository.getByUrl("homepage");

        Map<String, String> pageTexts =
                page.map(HomepageController::mapPage)
                        .orElseGet(Collections::emptyMap);

        model.addAttribute("name", name);
        model.addAttribute("page", page);
        model.addAttribute("pageTexts", pageTexts);

        return "front/index";
    }

}
