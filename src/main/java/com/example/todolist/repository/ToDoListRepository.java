package com.example.todolist.repository;

import com.example.todolist.model.ToDoListModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoListModel, Long> {
}
