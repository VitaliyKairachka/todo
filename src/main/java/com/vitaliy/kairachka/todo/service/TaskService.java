package com.vitaliy.kairachka.todo.service;

import com.vitaliy.kairachka.todo.model.entity.TaskEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Task service
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 16.06.2022
 */
@Service
public interface TaskService {
    /**
     * Get task by id
     *
     * @param id task
     * @return task entity
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 16.06.2022
     */
    TaskEntity getTaskById(Long id);

    /**
     * Get all task
     *
     * @param pageable task
     * @return all tasks
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 16.06.2022
     */
    Page<TaskEntity> getAllTasks(Pageable pageable);

    /**
     * Create task
     *
     * @param task entity
     * @return task entity
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 16.06.2022
     */
    TaskEntity createTask(TaskEntity task);

    /**
     * Update task
     *
     * @param id   task
     * @param task entity
     * @return task entity
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 16.06.2022
     */
    TaskEntity updateTask(Long id, TaskEntity task);

    /**
     * Delete task
     *
     * @param id task
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 16.06.2022
     */
    void deleteTask(Long id);
}
