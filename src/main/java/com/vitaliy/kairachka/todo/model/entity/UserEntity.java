package com.vitaliy.kairachka.todo.model.entity;

import com.vitaliy.kairachka.todo.model.enums.user.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.LAZY;

/**
 * User entity
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 16.06.2022
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserEntity extends BaseEntity {
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    @Enumerated(STRING)
    private Role role;

    @ManyToMany(mappedBy = "users", fetch = LAZY)
    private List<TaskEntity> tasks = new ArrayList<>();
}
