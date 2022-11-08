package ru.sfu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sfu.dao.WashingDao;
import ru.sfu.models.Washing;


/**
 * Класс контроллера по управлению добавления новых записей в БД.
 */
@Controller
@RequestMapping("/admin")
public class AddController {

    // Поле для возможности использования запросов к БД.
    private final WashingDao washingDAO;
    public AddController(WashingDao washingDAO) {
        this.washingDAO = washingDAO;
    }

    /**
     * Метод для вывода страницы с возможностью ввести данные для нового объекта.
     */
    @GetMapping("/add")
    public String newWashing(Model model) {
        model.addAttribute("washing", new Washing());
        return "add/add";
    }

    /**
     * Метод для сохранения в БД новой обхекта.
     * washing: объектс введёнными данными, который нужно сохранить.
     */
    @PostMapping("/add")
    public String createWashing(@ModelAttribute("washing") Washing washing) {

        // Получение айди последней записи.
        int id = washingDAO.findAll().size() + 1;
        washing.setId(id);
        // Добавление в БД.
        washingDAO.insert(washing);

        return "redirect:/table";
    }
}
