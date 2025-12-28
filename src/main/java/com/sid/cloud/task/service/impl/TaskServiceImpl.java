package com.sid.cloud.task.service.impl;

import com.sid.cloud.task.dto.TaskRequestDTO;
import com.sid.cloud.task.dto.TaskResponseDTO;
import com.sid.cloud.task.entity.Task;
import com.sid.cloud.task.mapper.TaskMapper;
import com.sid.cloud.task.repository.TaskRepository;
import com.sid.cloud.task.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO request) {
        Task task = TaskMapper.toEntity(request);
        Task saved = taskRepository.save(task);
        return TaskMapper.toResponse(saved);
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toResponse)
                .collect(Collectors.toList());
    }
}
