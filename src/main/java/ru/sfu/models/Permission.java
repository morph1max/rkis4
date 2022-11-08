package ru.sfu.models;


/**
 * Перечисление разрешений
 * Роли:
 * READ
 * WRITE
 */
public enum Permission {
    READ("read"),
    WRITE("write");
    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}