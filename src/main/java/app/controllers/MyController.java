package app.controllers;

import app.models.User;
import app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    private final UserService userService;
//    private final List<User> userList = List.of(
//            new User("Sergey", "Zolotaryov", (byte)26, "zolotaryov@mail.com"),
//            new User("Alexey", "Ivanov", (byte)25, "petrov@mail.com")
//            );

    public MyController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showUsers(Model model) {
        userService.setShowUsersModel(model);
//        model.addAttribute("userList", userList);
        return "thyme-users";
    }

    @RequestMapping("/add")
    public String addUser(Model model) {
        userService.setAddUserModel(model);
        return "add-or-update-user";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("userId") long id, Model model) {
        userService.setUpdateUserModel(model, id);
        return "add-or-update-user";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
