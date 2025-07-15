package app.common.controller;


public class AbstractController {

    public String redirect(String url) {
        return "redirect:" + url;
    }

}
