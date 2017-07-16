package app.admin.controller;

import app.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Samuel Butta
 */

@Controller
@RequestMapping("admin/users")
public class UserController {


    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/all")
    public String allUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "/admin/all";
    }

}
