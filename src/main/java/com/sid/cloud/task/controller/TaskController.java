package com.sid.cloud.task.controller;

import com.sid.cloud.task.dto.TaskRequestDTO;
import com.sid.cloud.task.dto.TaskResponseDTO;
import com.sid.cloud.task.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponseDTO create(@Valid @RequestBody TaskRequestDTO request) {
        return taskService.createTask(request);
    }

    @GetMapping
    public List<TaskResponseDTO> getAll() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskResponseDTO update(
            @PathVariable Long id,
            @RequestBody TaskRequestDTO request) {
        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
