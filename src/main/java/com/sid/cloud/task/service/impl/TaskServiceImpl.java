//package com.sid.cloud.task.service.impl;
//
//import com.sid.cloud.task.dto.TaskRequestDTO;
//import com.sid.cloud.task.dto.TaskResponseDTO;
//import com.sid.cloud.task.entity.Task;
//import com.sid.cloud.task.exception.TaskNotFoundException;
//import com.sid.cloud.task.mapper.TaskMapper;
//import com.sid.cloud.task.repository.TaskRepository;
//import com.sid.cloud.task.service.TaskService;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@Transactional
//public class TaskServiceImpl implements TaskService {
//
//    private final TaskRepository taskRepository;
//
//    public TaskServiceImpl(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }
//
//    @Override
//    public TaskResponseDTO createTask(TaskRequestDTO request) {
//        Task task = TaskMapper.toEntity(request);
//        Task saved = taskRepository.save(task);
//        return TaskMapper.toResponse(saved);
//    }
//
//    @Override
//    public List<TaskResponseDTO> getAllTasks() {
//        return taskRepository.findAll()
//                .stream()
//                .map(TaskMapper::toResponse)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public TaskResponseDTO getTaskById(Long id) {
//        Task task = taskRepository.findById(id)
//                .orElseThrow(() -> new TaskNotFoundException(id));
//        return TaskMapper.toResponse(task);
//    }
//
//    @Override
//    public TaskResponseDTO updateTask(Long id, TaskRequestDTO request) {
//        Task task = taskRepository.findById(id)
//                .orElseThrow(() -> new TaskNotFoundException(id));
//
//        task.setTitle(request.getTitle());
//        task.setDescription(request.getDescription());
//        task.setCompleted(request.isCompleted());
//
//        Task updated = taskRepository.save(task);
//        return TaskMapper.toResponse(updated);
//    }
//
//    @Override
//    public void deleteTask(Long id) {
//        Task task = taskRepository.findById(id)
//                .orElseThrow(() -> new TaskNotFoundException(id));
//        taskRepository.delete(task);
//    }
//}

package com.sid.cloud.task.service.impl;

import com.sid.cloud.task.dto.TaskRequestDTO;
import com.sid.cloud.task.dto.TaskResponseDTO;
import com.sid.cloud.task.entity.Task;
import com.sid.cloud.task.exception.TaskNotFoundException;
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
        return TaskMapper.toResponse(taskRepository.save(task));
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponseDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        return TaskMapper.toResponse(task);
    }

    @Override
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());

        return TaskMapper.toResponse(taskRepository.save(task));
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskRepository.delete(task);
    }
}
