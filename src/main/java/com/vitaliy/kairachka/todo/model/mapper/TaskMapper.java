package com.vitaliy.kairachka.todo.model.mapper;

import com.vitaliy.kairachka.todo.model.dto.TaskDto;
import com.vitaliy.kairachka.todo.model.entity.TaskEntity;

/**
 * Task mapper
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 17.06.2022
 */
public interface TaskMapper {
    /**
     * Convert task entity to response
     *
     * @param taskEntity need to convert
     * @return task dto
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 17.06.2022
     */
    TaskDto toResponse(TaskEntity taskEntity);

    /**
     * Convert task dto to request
     *
     * @param taskDto need to convert
     * @return task entity
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 17.06.2022
     */
    TaskEntity fromRequest(TaskDto taskDto);

    /**
     * Merge task data to save
     *
     * @param source need to merge
     * @param target need to save
     * @return user entity
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 17.06.2022
     */
    TaskEntity merge(TaskEntity source, TaskEntity target);
}
