package app.common.controller;

/**
 * @author Samuel Butta
 */
public class AbstractController {

    public String redirect(String url) {
        return "redirect:" + url;
    }

}
