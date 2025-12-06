package com.example.todolist.service;

import com.example.todolist.dto.ToDoListDto;
import com.example.todolist.mapper.ToDoListMapper;
import com.example.todolist.model.ToDoListModel;
import com.example.todolist.repository.ToDoListRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoListService {

    private ToDoListRepository toDoListRepository;
    private ToDoListMapper toDoListMapper;


    public ToDoListService(ToDoListRepository toDoListRepository, ToDoListMapper toDoListMapper) {
        this.toDoListRepository = toDoListRepository;
        this.toDoListMapper = toDoListMapper;
    }

    //Criar tarefa
    public ToDoListDto create(ToDoListDto toDoListDto) {
        ToDoListModel toDoListModel = toDoListMapper.map(toDoListDto);
        ToDoListModel todoSalvo = toDoListRepository.save(toDoListModel);
        return toDoListMapper.map(todoSalvo);
    }

    //Ver tarefas
    public List<ToDoListDto> listar() {
        List<ToDoListModel> toDoListModels = toDoListRepository.findAll();
        return toDoListModels.stream()
                .map(toDoListMapper::map)
                .collect(Collectors.toList());

    }

    //Ver tarefas pendentes
    public List<ToDoListDto> listarPendentes() {
        return toDoListRepository.findAll().stream()
                .filter(t -> !t.getStatusDeConclusao())
                .map(toDoListMapper::map)
                .toList();
    }

    //Atualizar tarefas
    public ToDoListDto update(Long id, ToDoListDto toDoListDto) {
        Optional<ToDoListModel> model = toDoListRepository.findById(id);
        if (model.isPresent()) {
            ToDoListModel tarefa = toDoListMapper.map(toDoListDto);
            tarefa.setId(id);
            return toDoListMapper.map(tarefa);
        } else {
            return null;
        }
    }

    //Deletar tarefas
    public void delete(Long id) {
        Optional<ToDoListModel> model = toDoListRepository.findById(id);
        if (model.isPresent()) {
            toDoListRepository.deleteById(id);
        } else {
            return;
        }
    }
}
