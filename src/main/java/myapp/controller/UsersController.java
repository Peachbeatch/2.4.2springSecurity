package myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import myapp.model.User;
import myapp.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UsersController {

    private final UserServiceImpl userService;

    @Autowired
    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showUserInfo(@AuthenticationPrincipal User currentUser, Model model) {
        model.addAttribute("currentUser",
                userService.loadUserByUsername(currentUser.getUsername()));
        return "user/user_info";
    }

}