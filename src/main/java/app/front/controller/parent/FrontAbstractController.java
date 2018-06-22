package app.front.controller.parent;

import app.common.controller.AbstractController;
import app.common.service.cms.api.PageService;
import app.persistence.entity.cms.Page;
import app.persistence.repository.cms.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.Map;
import java.util.Optional;

/**
 * @author Samuel Butta
 */
public class FrontAbstractController extends AbstractController {


    @Autowired
    protected PageRepository pageRepository;

    @Autowired
    protected PageService pageService;


    public void addPageData(Model model, String pageIdentity) {
        Optional<Page> pageOpt = pageRepository.getByUrl(pageIdentity);
        Map<String, String> pageTexts = pageService.createPageTextsMap(pageOpt);
        Map<String, String> pageImages = pageService.createPageImagesMap(pageOpt);


        model.addAttribute("pageTexts", pageTexts);
        model.addAttribute("pageImages", pageImages);
    }

}
