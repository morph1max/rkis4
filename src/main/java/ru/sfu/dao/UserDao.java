package ru.sfu.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sfu.models.Role;
import ru.sfu.models.User;

import javax.sql.DataSource;
import java.util.List;


/**
 * Класс для обработки запросов к БД.
 */
@Component
public class UserDao {
    JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * Метод вставки данных юзера в БД.
     * user: пользователь, которого нужно добавить в БД (User).
     */
    public void insert(User user){

        List<User> users = jdbcTemplate.query("SELECT * FROM customUser", new
                BeanPropertyRowMapper<User>(User.class));

        user.setId(users.size()+1);
        user.setRole(Role.USER);

        jdbcTemplate.update("INSERT INTO customUser " +
                        "(id, username, password, role) " +
                        "VALUES (?, ?, ?, ?)",
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getRole().toString()
        );
    }
}
