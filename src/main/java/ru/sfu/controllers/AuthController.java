package ru.sfu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sfu.dao.UserDao;
import ru.sfu.dao.WashingDao;
import ru.sfu.models.Role;
import ru.sfu.models.User;
import ru.sfu.models.Washing;

/**
 * Класс-контроллер для регистрации и авторизации.
 */
@Controller
public class AuthController {

    private final UserDao userDAO;
    public AuthController(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    /**
    * Get-метод регистрации.
    */
    @GetMapping("/register")
    public String registerGet(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    /**
    * Post-метод регистрации с созданием нового пользователя.
    */
    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") User user) {
        userDAO.insert(user);
        return "redirect:/login";
    }

    /**
    * Get-метод авторизации пользователя.
    */
    @GetMapping("/login")
    public String loginPage(Model model) {
        return "auth/login";
    }
}
