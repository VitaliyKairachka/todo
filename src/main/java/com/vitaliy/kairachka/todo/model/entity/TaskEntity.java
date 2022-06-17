package com.vitaliy.kairachka.todo.model.entity;

import com.vitaliy.kairachka.todo.model.enums.tasks.Priority;
import com.vitaliy.kairachka.todo.model.enums.tasks.Status;
import com.vitaliy.kairachka.todo.model.enums.tasks.Type;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;

/**
 * Task entity
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 16.06.2022
 */
@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TaskEntity extends BaseEntity {
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
