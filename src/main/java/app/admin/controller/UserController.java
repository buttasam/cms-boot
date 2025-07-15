package app.admin.controller;

import app.admin.controller.parent.AdminAbstractController;
import app.config.anotation.AdminController;
import app.persistence.entity.auth.User;
import app.persistence.repository.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Samuel Butta
 */

@AdminController
@RequestMapping("admin/users")
public class UserController extends AdminAbstractController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/all")
    public String allUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "/admin/all";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam Long userId) {
        User user = userRepository.getReferenceById(userId);
        user.setActive(false);
        userRepository.save(user);

        return redirect("/admin/users/all");
    }

}
