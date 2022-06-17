package com.vitaliy.kairachka.todo.service.impl;

import com.vitaliy.kairachka.todo.model.entity.TaskEntity;
import com.vitaliy.kairachka.todo.model.enums.tasks.Status;
import com.vitaliy.kairachka.todo.model.mapper.TaskMapper;
import com.vitaliy.kairachka.todo.repository.TaskRepository;
import com.vitaliy.kairachka.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Task service implementation
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 17.06.2022
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskEntity getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> {
            //TODO exception
            return null;
        });
    }

    @Override
    public Page<TaskEntity> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public TaskEntity createTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    @Transactional
    public TaskEntity updateTask(Long id, TaskEntity task) {
        TaskEntity target = this.getTaskById(id);
        target = taskMapper.merge(task, target);
        target.setStatus(Status.TODO);
        return taskRepository.save(target);
    }

    @Override
    @Transactional
    public void deleteTask(Long id) {
        this.getTaskById(id);
        taskRepository.deleteById(id);
    }
}
