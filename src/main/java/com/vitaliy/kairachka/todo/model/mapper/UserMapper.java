package com.vitaliy.kairachka.todo.model.mapper;

import com.vitaliy.kairachka.todo.model.dto.UserDto;
import com.vitaliy.kairachka.todo.model.entity.UserEntity;

/**
 * User mapper
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 17.06.2022
 */
public interface UserMapper {
    /**
     * Convert user entity to response
     *
     * @param userEntity need to convert
     * @return user dto
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 17.06.2022
     */
    UserDto toResponse(UserEntity userEntity);

    /**
     * Convert user dto to request
     *
     * @param userDto need to convert
     * @return user entity
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 17.06.2022
     */
    UserEntity fromRequest(UserDto userDto);

    /**
     * Merge user data to save
     *
     * @param source need to merge
     * @param target need to save
     * @return user entity
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 17.06.2022
     */
    UserEntity merge(UserEntity source, UserEntity target);
}
