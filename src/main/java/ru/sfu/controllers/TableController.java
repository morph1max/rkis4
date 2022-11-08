package ru.sfu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sfu.dao.WashingDao;
import ru.sfu.models.Washing;

import java.util.List;


/**
 * Класс-контроллер для вывода всех объектов из БД.
 */
@Controller
@RequestMapping("/user")
public class TableController {

    private final WashingDao washingDAO;
    public TableController(WashingDao washingDAO) {
        this.washingDAO = washingDAO;
    }

    /**
     * Метод для вывода всех объектов из БД.
     */
    @GetMapping("/table")
    public String mainPage(Model model) {

        List<Washing> washings = washingDAO.findAll();
        model.addAttribute("washings", washings);

        return "table/table";
    }
}
