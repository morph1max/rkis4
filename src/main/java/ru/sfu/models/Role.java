package ru.sfu.models;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.sfu.models.Permission;

import java.util.Set;
import java.util.stream.Collectors;


/**
 * Перечисление ролей
 * Роли:
 * USER
 * ADMIN
 */
public enum Role {
    USER(Set.of(Permission.READ)),
    ADMIN(Set.of(Permission.WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(
                        permission.getPermission()))
                .collect(Collectors.toSet());
    }
}