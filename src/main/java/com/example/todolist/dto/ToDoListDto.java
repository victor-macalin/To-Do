package com.example.todolist.dto;

import jakarta.persistence.Column;

public class ToDoListDto {
    private Long id;
    private String name;
    private boolean statusDeConclusao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatusDeConclusao() {
        return statusDeConclusao;
    }

    public void setStatusDeConclusao(boolean statusDeConclusao) {
        this.statusDeConclusao = statusDeConclusao;
    }
}
