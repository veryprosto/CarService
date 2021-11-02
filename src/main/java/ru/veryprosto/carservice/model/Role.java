package ru.veryprosto.carservice.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
   WORKER("Мастер"), ADMIN("Администратор");

   private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getAuthority() {
        return name(); //строковое представление значения енама
    }
}