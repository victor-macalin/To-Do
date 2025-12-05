package com.example.todolist.service;

import com.example.todolist.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

@Service
public class ToDoListService {
    private ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    //Criar tarefa

    //Ver tarefas

    //Atualizar tarefas

    //Deletar tarefas
}
