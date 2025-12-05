package com.example.todolist.mapper;

import com.example.todolist.dto.ToDoListDto;
import com.example.todolist.model.ToDoListModel;
import org.springframework.stereotype.Component;

@Component
public class ToDoListMapper {
    public ToDoListModel map(ToDoListDto toDoListDto) {
        ToDoListModel todoModel = new ToDoListModel();
        todoModel.setId(toDoListDto.getId());
        todoModel.setName(toDoListDto.getName());
        todoModel.setStatusDeConclusao(toDoListDto.getStatusDeConclusao());
        return todoModel;
    }
    public ToDoListDto map(ToDoListModel toDoListModel) {
        ToDoListDto todoDto = new ToDoListDto();
        todoDto.setId(toDoListModel.getId());
        todoDto.setName(toDoListModel.getName());
        todoDto.setStatusDeConclusao(toDoListModel.getStatusDeConclusao());
        return todoDto;
    }

}
