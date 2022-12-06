package ru.sfu.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    private final RabbitTemplate rabbitTemplate;
    public WashingController(WashingDao washingDAO, RabbitTemplate rabbitTemplate) {
        this.washingDAO = washingDAO;
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Метод для вывода всех объектов из БД.
     */
    @GetMapping("/washing")
    public String getAllWashing() {

        List<Washing> washings = washingDAO.findAll();

        rabbitTemplate.convertAndSend(
                "student-queue",
                "get list washings " + washings
        );

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

        rabbitTemplate.convertAndSend(
                "student-queue",
                "get one washing id=" + id + " " + washing
        );

        return washing.toString();
    }

    @PostMapping(value="/washing/add")
    public String addWashing(@RequestBody Washing washing) {

        washingDAO.insert(washing);

        rabbitTemplate.convertAndSend(
                "student-queue",
                "add washing " + washing
        );

        return washing.toString();
    }

    @PutMapping("/washing/put/{id}")
    public String putWashing(
            @PathVariable("id") int id,
            @RequestBody Washing washing
    ) {

        rabbitTemplate.convertAndSend(
                "student-queue",
                "put washing " + washing
        );

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

        rabbitTemplate.convertAndSend(
                "student-queue",
                "delete washing" + washing
        );

        washingDAO.delete(id);

        return washing.toString();
    }
}
