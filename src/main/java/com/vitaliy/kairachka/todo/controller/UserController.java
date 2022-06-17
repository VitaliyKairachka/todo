package com.vitaliy.kairachka.todo.controller;

import com.vitaliy.kairachka.todo.model.dto.UserDto;
import com.vitaliy.kairachka.todo.model.mapper.UserMapper;
import com.vitaliy.kairachka.todo.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * User controller
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 17.06.2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private static final String ID = "id";
    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<Page<UserDto>> getAll(@PageableDefault(size = 5) Pageable pageable) {
        Page<UserDto> users = userService
                .getAllUsers(pageable)
                .map(userMapper::toResponse);
        return new ResponseEntity<>(users, OK);
    }

    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<UserDto> getUser(@PathVariable(ID) Long id) {
        UserDto user = Optional.of(id)
                .map(userService::getUserById)
                .map(userMapper::toResponse)
                .orElseThrow();
        return new ResponseEntity<>(user, OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user) {
        UserDto userDto = Optional.ofNullable(user)
                .map(userMapper::fromRequest)
                .map(userService::createUser)
                .map(userMapper::toResponse)
                .orElseThrow();
        return new ResponseEntity<>(userDto, CREATED);
    }

    @PatchMapping("/{id:[\\d]+}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(ID) Long id,
                                              @RequestBody @Valid UserDto userDto) {
        UserDto userResponse = Optional.ofNullable(userDto)
                .map(userMapper::fromRequest)
                .map(user -> userService.updateUser(id, user))
                .map(userMapper::toResponse)
                .orElseThrow();
        return new ResponseEntity<>(userResponse, OK);
    }

    @DeleteMapping("/{id:[\\d]+}")
    public ResponseEntity<?> deleteUser(@PathVariable(ID) Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(OK);
    }
}
