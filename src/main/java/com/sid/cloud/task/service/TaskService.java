package com.sid.cloud.task.service;

import com.sid.cloud.task.dto.TaskRequestDTO;
import com.sid.cloud.task.dto.TaskResponseDTO;

import java.util.List;

public interface TaskService {

    TaskResponseDTO createTask(TaskRequestDTO request);

    List<TaskResponseDTO> getAllTasks();

    TaskResponseDTO getTaskById(Long id);

    TaskResponseDTO updateTask(Long id, TaskRequestDTO request);

    void deleteTask(Long id);
}
