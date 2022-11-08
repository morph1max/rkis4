package ru.sfu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sfu.dao.WashingDao;
import ru.sfu.models.Washing;


/**
 * Класс-контроллер для редактирования записей из БД.
 */
@Controller
@RequestMapping("/admin")
public class EditController {

    private final WashingDao washingDAO;
    public EditController(WashingDao washingDAO) {
        this.washingDAO = washingDAO;
    }

    /**
     * Метод для получения айди записи, которую нужно отредактировать.
     * id: введённый айди записи для редактирования.
     */
    @GetMapping("/edit")
    public String editPage(@RequestParam(value="id", required=false) String id, Model model) {

        int currentId = -1;
        String error = "";

        // Проверка на корректность ввода параметра id.
        if (id != null && id.matches("[-+]?\\d+")) {
            currentId = Integer.parseInt(id);
            if (currentId < 0) {
                error = "Id не может быть отрицательным.";
            }

        // В параметр id ввели буквы.
        } else if (id != null) {
            error = "В вышем Id присуствуют буквы.";
        }
        model.addAttribute("error", error);

        // Достаём запись из БД по айди.
        Washing currentWashing = null;
        if (currentId != -1) {
            for (Washing washing : washingDAO.findAll()) {
                if (washing.getId() == currentId) {
                    currentWashing = washing;
                    break;
                }
            }
        }

        model.addAttribute("washing", currentWashing);
        return "edit/edit";
    }

    /**
     * Метод для обновления записи в БД.
     * washing: обновлённый объект, который нужно сохранить в БД.
     * id: айди записи, которую нужно заменить на новую.
     */
    @PatchMapping("/update/{id}")
    public String update(@ModelAttribute("washing") Washing washing, @PathVariable("id") int id) {
        washingDAO.edit(id, washing);
        return "redirect:/table";
    }
}
