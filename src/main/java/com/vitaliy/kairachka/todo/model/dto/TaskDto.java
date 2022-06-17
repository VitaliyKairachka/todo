package com.vitaliy.kairachka.todo.model.dto;

import com.vitaliy.kairachka.todo.model.enums.tasks.Priority;
import com.vitaliy.kairachka.todo.model.enums.tasks.Status;
import com.vitaliy.kairachka.todo.model.enums.tasks.Type;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;

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
    private Long id;

    private Long version;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotBlank
    @Size(max = 255)
    private String name;

    private String description;

    private LocalDateTime executionTime;

    @Enumerated(STRING)
    private Type type;

    @Enumerated(STRING)
    private Priority priority;

    @Enumerated(STRING)
    private Status status;
}
