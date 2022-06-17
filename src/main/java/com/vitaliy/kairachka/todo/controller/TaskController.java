package com.vitaliy.kairachka.todo.controller;

import com.vitaliy.kairachka.todo.model.dto.TaskDto;
import com.vitaliy.kairachka.todo.service.impl.TaskServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * Task controller
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 16.06.2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {
    private static final String ID = "id";
    private final TaskServiceImpl taskService;

    @GetMapping
    public ResponseEntity<Page<TaskDto>> getAll(@PageableDefault(size = 5) Pageable pageable) {
        Page<TaskDto> users = taskService.getAllTasks(pageable)
                .map();  //TODO mapper
        return new ResponseEntity<>(users, OK);
    }

    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<TaskDto> getUser(@PathVariable(ID) Long id) {
        TaskDto task = Optional.of(id)
                .map(taskService::getTaskById)
                .map()  //TODO mapper
                .orElseThrow();
        return new ResponseEntity<>(task, OK);
    }

    @PostMapping
    public ResponseEntity<TaskDto> createUser(@RequestBody @Valid TaskDto task) {
        TaskDto taskDto = Optional.ofNullable(task)
                .map()  //TODO mapper
                .map(taskService::createTask)
                .map()  //TODO mapper
                .orElseThrow();
        return new ResponseEntity<>(taskDto, CREATED);
    }

    @PatchMapping("/{id:[\\d]+}")
    public ResponseEntity<TaskDto> updateUser(@PathVariable(ID) Long id,
                                              @RequestBody @Valid TaskDto taskDto) {
        TaskDto taskResponse = Optional.ofNullable(taskDto)
                .map(taskMapper::fromRequestUpdate)    //TODO mapper
                .map(task -> taskService.updateTask(id, task))
                .map(taskMapper::toResponse)    //TODO mapper
                .orElseThrow();
        return new ResponseEntity<>(taskResponse, OK);
    }

    @DeleteMapping("/{id:[\\d]+}")
    public ResponseEntity<?> deleteUser(@PathVariable(ID) Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(OK);
    }
}
