package ru.sfu.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sfu.models.Washing;

import javax.sql.DataSource;
import java.util.List;


/**
 * Класс для обработки запросов к БД.
 */
@Component
public class WashingDao {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Метод вставки данных стиральной машины в БД.
     * washing: стиральная машина, которую нужно добавить в БД (Washing).
     */
    public void insert(Washing washing){
        jdbcTemplate.update("INSERT INTO washing " +
                "(id, weight, clothingCapacity, manufacturingCompany, model, ProducingCountry) " +
                "VALUES (?, ?, ?, ?, ?, ?)",
                washing.getId(),
                washing.getWeight(),
                washing.getClothingCapacity(),
                washing.getManufacturingCompany(),
                washing.getModel(),
                washing.getProducingCountry()
        );
    }

    /**
     * Метод получения абсолютно всех стиральных машин в БД.
     * return: List<Washing>.
     */
    public List<Washing> findAll(){
        List<Washing> washings = jdbcTemplate.query("SELECT * FROM washing", new
                BeanPropertyRowMapper<Washing>(Washing.class));
        return washings;
    }

    /**
     * Метод редактирования одной стиральной машины в БД.
     * id: айди стиральной машины (int),
     * washing: обновлённая стиральная машина (Washing).
     */
    public void edit(int id, Washing washing) {
        jdbcTemplate.update("UPDATE washing " +
                    "SET id=?, weight=?, clothingCapacity=?, manufacturingCompany=?, model=?, ProducingCountry=?" +
                    "WHERE id=?",
            washing.getId(),
            washing.getWeight(),
            washing.getClothingCapacity(),
            washing.getManufacturingCompany(),
            washing.getModel(),
            washing.getProducingCountry(),
            id
        );
    }

    /**
     * Метод удаления одной стиральной машины из БД.
     * id: айди стиральной машины (int),
     */
    public void delete(int id) {
        jdbcTemplate.update(
                "DELETE from washing WHERE id=?",
                id
        );
    }

    /**
     * Метод поиска стиральных машин в БД, удовлятворяющих условию вводимого значения веса.
     * weight: значение веса (int),
     * return: List<Washing>
     */
    public List<Washing> search(int weight){
        List<Washing> washing = jdbcTemplate.query("SELECT * FROM washing WHERE weight<?",
                new Object[]{weight},
                new BeanPropertyRowMapper<>(Washing.class));
        return washing;
    }
}
