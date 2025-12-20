package com.example.todolist.controller;

import com.example.todolist.dto.ToDoListDto;
import com.example.todolist.mapper.ToDoListMapper;
import com.example.todolist.repository.ToDoListRepository;
import com.example.todolist.service.ToDoListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


        // Criar tarefa
        @Operation(
                summary = "Criar uma nova tarefa",
                description = "Cria uma nova tarefa na lista de afazeres"
        )
        @ApiResponses(value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Tarefa criada com sucesso"
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Dados inválidos",
                        content = @Content
                )
        })
        @PostMapping("/create")
        public ResponseEntity<String> create(@RequestBody ToDoListDto toDoListDto) {
            toDoListService.create(toDoListDto);
            return ResponseEntity.ok("Tarefa criada com sucesso");
        }

        // Ver todas as tarefas
        @Operation(
                summary = "Listar todas as tarefas",
                description = "Retorna todas as tarefas cadastradas"
        )
        @ApiResponses(value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Lista de tarefas retornada com sucesso",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ToDoListDto.class)
                        )
                )
        })
        @GetMapping("/listar")
        public ResponseEntity<List<ToDoListDto>> read() {
            List<ToDoListDto> listDtos = toDoListService.listar();
            return ResponseEntity.ok(listDtos);
        }

        // Ver tarefas pendentes
        @Operation(
                summary = "Listar tarefas pendentes",
                description = "Retorna apenas as tarefas que ainda não foram concluídas"
        )
        @ApiResponses(value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Tarefas pendentes encontradas",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = ToDoListDto.class)
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Não existem tarefas pendentes",
                        content = @Content
                )
        })
        @GetMapping("/listarpendentes")
        public ResponseEntity<?> verPendentes() {
            List<ToDoListDto> toDoListDtos = toDoListService.listarPendentes();
            if (toDoListDtos != null && !toDoListDtos.isEmpty()) {
                return ResponseEntity.ok(toDoListDtos);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nao existe tarefas pendentes");
        }

        // Atualizar tarefa
        @Operation(
                summary = "Atualizar uma tarefa",
                description = "Atualiza uma tarefa existente pelo ID"
        )
        @ApiResponses(value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Tarefa atualizada com sucesso"
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Tarefa não encontrada",
                        content = @Content
                )
        })
        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@RequestBody ToDoListDto toDoListDto,
                                        @PathVariable Long id) {
            if (toDoListRepository.findById(id).isPresent()) {
                toDoListService.update(id, toDoListDto);
                return ResponseEntity.ok("Tarefa atualizada com sucesso");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Tarefa nao encontrada");
            }
        }

        // Deletar tarefa
        @Operation(
                summary = "Deletar uma tarefa",
                description = "Remove uma tarefa existente pelo ID"
        )
        @ApiResponses(value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Tarefa deletada com sucesso"
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Tarefa não encontrada",
                        content = @Content
                )
        })
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> delete(@PathVariable Long id) {
            if (toDoListRepository.findById(id).isPresent()) {
                toDoListService.delete(id);
                return ResponseEntity.ok("Tarefa deletada com sucesso");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Tarefa nao encontrada");
            }
        }
    }


