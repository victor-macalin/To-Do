package com.example.todolist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todo_list")
public class ToDoListModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
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
