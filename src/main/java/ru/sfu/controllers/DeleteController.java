package ru.sfu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sfu.dao.WashingDao;

/**
 * Класс-контроллер для удаления записей из БД.
 */
@Controller
@RequestMapping("/admin")
public class DeleteController {

    private final WashingDao washingDAO;
    public DeleteController(WashingDao washingDAO) {
        this.washingDAO = washingDAO;
    }

    /**
     * Метод для ввода айди для удаления объекта из БД объекта.
     * id: айди объекта, который нужно удалить.
     */
    @GetMapping("/delete")
    public String inputIdDelete(@RequestParam(value="id", required=false) String id, Model model) {

        int currentId = -1;
        String error = "";

        // Проверка на корректность ввода параметра веса.
        if (id != null && id.matches("[-+]?\\d+")) {
            currentId = Integer.parseInt(id);
            // Вес не может быть отрицательным.
            if (currentId < 0) {
                error = "Id не может быть отрицательным.";
            }

            // В параметр веса ввели буквы.
        } else if (id != null) {
            error = "В вышем Id присуствуют буквы.";
        }
        model.addAttribute("error", error);

        if (error.equals("") && id != null) {
            // Посылаем запрос на удаление.
            return deleteWashing(currentId);
        } else {
            // Даём возможность ввести айди.
            return "delete/delete";
        }
    }

    /**
     * Метод для удаления объекта из БД объекта.
     * id: айди объекта, который нужно удалить.
     */
    @DeleteMapping("/delete/{id}")
    public String deleteWashing(@PathVariable("id") int id) {
        washingDAO.delete(id);
        return "redirect:/table";
    }
}
