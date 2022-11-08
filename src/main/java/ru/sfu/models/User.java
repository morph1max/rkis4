package ru.sfu.models;

import ru.sfu.models.Role;


/**
 * Класс пользователя системы
 * Поля:
 * id (int): идентификатор стиральной машины.
 * username (String): никнейм пользователя.
 * password (String): пароль пользователя
 * role (Role): роль пользователя.
 */
public class User {
    int id;
    String username;
    String password;
    Role role;

    /**
     * Конструктор со всеми параметрами.
     */
    public User(int id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
