package com.example.todolist.controller;

import com.example.todolist.dto.ToDoListDto;
import com.example.todolist.mapper.ToDoListMapper;
import com.example.todolist.repository.ToDoListRepository;
import com.example.todolist.service.ToDoListService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class ToDoListController {

    private final ToDoListService toDoListService;
    private final ToDoListRepository toDoListRepository;

    public ToDoListController(ToDoListService toDoListService, ToDoListRepository toDoListRepository) {
        this.toDoListService = toDoListService;
        this.toDoListRepository = toDoListRepository;
    }

    //Criar tarefa
    @PostMapping("/create")
    public ResponseEntity<String> create (@RequestBody ToDoListDto toDoListDto){
        toDoListService.create(toDoListDto);
        return ResponseEntity.ok("Tarefa criada com sucesso");
    }

    //Ver tarefas
    @GetMapping("/listar")
    public ResponseEntity<List<ToDoListDto>> read () {
        List<ToDoListDto> listDtos = toDoListService.listar();
        return ResponseEntity.ok(listDtos);
    }
    //ver tarefas pendentes
    @GetMapping("/listarpendentes")
    public ResponseEntity<?> verPendentes (){
        List<ToDoListDto> toDoListDtos =  toDoListService.listarPendentes();
        if (toDoListDtos != null) {
            return ResponseEntity.ok(toDoListDtos);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Nao existe tarefas pendentes");
    }

    //Atualizar tarefas
    @PutMapping("/update/{id}")
 public ResponseEntity<?> update (@RequestBody ToDoListDto toDoListDto, @PathVariable Long id){

       if (toDoListRepository.findById(id) != null) {
           toDoListService.update(id, toDoListDto);
           return ResponseEntity.ok("Tarefa atualizada com sucesso");
       }else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
                   .body("Tarefa nao encontrada");
       }
    }
    //Deletar tarefas
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id) {
        if (toDoListRepository.findById(id) != null){
            toDoListService.delete(id);
            return ResponseEntity.ok("Tarefa deletada com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tarefa nao encontrada");
        }
    }

}
