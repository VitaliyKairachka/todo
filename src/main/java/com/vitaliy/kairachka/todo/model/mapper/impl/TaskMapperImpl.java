package com.vitaliy.kairachka.todo.model.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitaliy.kairachka.todo.model.dto.TaskDto;
import com.vitaliy.kairachka.todo.model.entity.TaskEntity;
import com.vitaliy.kairachka.todo.model.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Task mapper
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 17.06.2022
 */
@Component
@RequiredArgsConstructor
public class TaskMapperImpl implements TaskMapper {
    private final ObjectMapper objectMapper;

    @Override
    public TaskDto toResponse(TaskEntity taskEntity) {
        return objectMapper.convertValue(taskEntity, TaskDto.class);
    }

    @Override
    public TaskEntity fromRequest(TaskDto taskDto) {
        return objectMapper.convertValue(taskDto, TaskEntity.class);
    }

    @Override
    public TaskEntity merge(TaskEntity source, TaskEntity target) {
        if (source.getName() != null) target.setName(source.getName());
        if (source.getDescription() != null) target.setDescription(source.getDescription());
        if (source.getExecutionTime() != null) target.setExecutionTime(source.getExecutionTime());
        if (source.getType() != null) target.setType(source.getType());
        if (source.getPriority() != null) target.setPriority(source.getPriority());
        return target;
    }
}
