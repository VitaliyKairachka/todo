package com.vitaliy.kairachka.todo.model.dto;

import com.vitaliy.kairachka.todo.model.enums.user.Role;
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
    private Long id;

    private Long version;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotBlank
    @Size(max = 255)
    private String username;

    @Size(max = 255)
    private String password;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Size(max = 255)
    private String email;

    @Enumerated(STRING)
    private Role role;
}
