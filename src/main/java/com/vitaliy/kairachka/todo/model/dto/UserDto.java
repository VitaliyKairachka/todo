package com.vitaliy.kairachka.todo.model.dto;

import com.vitaliy.kairachka.todo.model.enums.user.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import static jakarta.persistence.EnumType.STRING;

/**
 * User data transfer object
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
public class UserDto {
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    @Enumerated(STRING)
    private Role role;
}
