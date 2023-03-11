package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

@Controller
public class MyController {
    private final UserService userService;

    public MyController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "users";
    }
}
