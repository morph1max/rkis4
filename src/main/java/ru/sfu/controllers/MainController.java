package ru.sfu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


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
}
