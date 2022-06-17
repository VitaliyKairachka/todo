package com.vitaliy.kairachka.todo.model.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitaliy.kairachka.todo.model.dto.UserDto;
import com.vitaliy.kairachka.todo.model.entity.UserEntity;
import com.vitaliy.kairachka.todo.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * User mapper
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 17.06.2022
 */
@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {
    private final ObjectMapper objectMapper;

    @Override
    public UserDto toResponse(UserEntity userEntity) {
        return objectMapper.convertValue(userEntity, UserDto.class);
    }

    @Override
    public UserEntity fromRequest(UserDto userDto) {
        return objectMapper.convertValue(userDto, UserEntity.class);
    }

    @Override
    public UserEntity merge(UserEntity source, UserEntity target) {
        if (source.getUsername() != null) target.setUsername(source.getUsername());
        if (source.getPassword() != null) target.setPassword(source.getPassword());
        if (source.getFirstName() != null) target.setFirstName(source.getFirstName());
        if (source.getLastName() != null) target.setLastName(source.getLastName());
        if (source.getEmail() != null) target.setEmail(source.getEmail());
        return target;
    }
}
