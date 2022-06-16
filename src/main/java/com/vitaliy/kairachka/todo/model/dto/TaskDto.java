package com.vitaliy.kairachka.todo.model.dto;

import com.vitaliy.kairachka.todo.model.enums.tasks.Priority;
import com.vitaliy.kairachka.todo.model.enums.tasks.Status;
import com.vitaliy.kairachka.todo.model.enums.tasks.Type;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * Task data transfer object
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 16.06.2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TaskDto {
    private String name;

    private String description;

    private LocalDateTime executionTime;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;
}
