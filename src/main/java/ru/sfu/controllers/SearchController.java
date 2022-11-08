package ru.sfu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sfu.dao.WashingDao;


/**
 * Класс-контроллер для поиска объектов по заданному условию.
 */
@Controller
@RequestMapping("/user")
public class SearchController {
    private final WashingDao washingDAO;
    public SearchController(WashingDao washingDAO) {
        this.washingDAO = washingDAO;
    }

    /**
     * Метод для поиска объектов по заданному условию.
     * Ищутся все стиральные машины, которые меньше paramWeight.
     * paramWeight: максимальный вес стиральных машин.
     */
    @GetMapping("/search")
    public String searchPage(@RequestParam(value="weight", required=false) String paramWeight, Model model) {

        String error;
        int maxWeight;

        // Проверка на корректность ввода параметра веса.
        if (paramWeight != null && paramWeight.matches("[-+]?\\d+")) {
            maxWeight = Integer.parseInt(paramWeight);

            // Вес не может быть отрицательным.
            if (maxWeight < 0) {
                error = "Вес не может быть отрицательным.";
                model.addAttribute("error", error);
            }

            model.addAttribute("searchWashing", washingDAO.search(maxWeight));

        // В параметр веса ввели буквы.
        } else if (paramWeight != null) {
            error = "В вашем вводе присуствуют буквы.";
            model.addAttribute("error", error);
        }

        return "search/search";
    }
}
