package app.front.controller;

import app.persistence.entity.cms.Page;
import app.persistence.entity.cms.PageText;
import app.persistence.repository.cms.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Samuel Butta
 */
@Controller
public class HomepageController {


    private PageRepository pageRepository;

    @Autowired
    public HomepageController(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @RequestMapping("/")
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name, Model model) {

        Page page = pageRepository.findByUrl("homepage");
        Map<String, String> pageTexts = page.getPageTexts().stream().collect(Collectors.toMap(PageText::getIdentity, PageText::getContent));

        model.addAttribute("name", name);
        model.addAttribute("page", page);
        model.addAttribute("pageTexts", pageTexts);

        return "front/index";
    }

}
