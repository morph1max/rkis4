package ru.sfu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sfu.dao.WashingDao;
import ru.sfu.models.Washing;

import java.util.List;


/**
 * Класс-контроллер для вывода всех объектов из БД.
 */
@RestController
public class WashingController {

    private final WashingDao washingDAO;
    public WashingController(WashingDao washingDAO) {
        this.washingDAO = washingDAO;
    }

    /**
     * Метод для вывода всех объектов из БД.
     */
    @GetMapping("/washing")
    public String getAllWashing() {

        List<Washing> washings = washingDAO.findAll();
        return washings.toString();
    }

    @GetMapping("/washing/{id}")
    public String getOneWashing(@PathVariable("id") int id) {

        List<Washing> washings = washingDAO.findAll();

        Washing washing = null;
        for (Washing w: washings) {
            if (w.getId() == id) {
                washing = w;
                break;
            }
        }
        return washing.toString();
    }

    @PostMapping(value="/washing/add")
    public String addWashing(@RequestBody Washing washing) {

        washingDAO.insert(washing);
        return washing.toString();
    }

    @PutMapping("/washing/put/{id}")
    public String putWashing(
            @PathVariable("id") int id,
            @RequestBody Washing washing
    ) {

        washingDAO.edit(id, washing);
        return washing.toString();
    }

    @DeleteMapping("/washing/delete/{id}")
    public String deleteWashing(@PathVariable("id") int id) {

        List<Washing> washings = washingDAO.findAll();
        Washing washing = null;
        for (Washing w: washings) {
            if (w.getId() == id) {
                washing = w;
                break;
            }
        }

        washingDAO.delete(id);

        return washing.toString();
    }
}
