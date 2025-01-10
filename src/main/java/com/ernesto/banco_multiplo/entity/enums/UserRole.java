package com.ernesto.banco_multiplo.entity.enums;

/*
 * @author: Ernesto Adriano
 * */
public enum UserRole {

    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
