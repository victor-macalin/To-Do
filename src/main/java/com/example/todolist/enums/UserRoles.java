package com.example.todolist.enums;

public enum UserRoles {

    ADMIN("admim"),
    USER("user");
    private String roles;

    UserRoles(String roles) {
        this.roles = roles;
    }

    public String getRole(){
        return roles;
    }
}
