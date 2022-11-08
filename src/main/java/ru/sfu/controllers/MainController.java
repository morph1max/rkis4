package ru.sfu.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.sfu.models.Washing;

/**
 * Класс-контроллер для вывода главной страницы.
 */
@Controller
public class MainController {

    /**
     * Метод для вывода главной страницы.
     */
    @GetMapping("/")
    public String mainPage() {
        return "main/main";
    }

    /**
    * Get-метод перехода на главную страницу роли USER.
    */
    @GetMapping("/user")
    public String mainUserPage(Authentication authentication, Model model) {
        model.addAttribute("username", authentication.getName());
        return "main/mainUser";
    }

    /**
    * Get-метод перехода на главную страницу роли ADMIN.
    */
    @GetMapping("/admin")
    public String mainAdminPage(Authentication authentication, Model model) {
        model.addAttribute("username", authentication.getName());
        return "main/mainAdmin";
    }
}
