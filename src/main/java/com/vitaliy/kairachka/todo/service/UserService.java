package com.vitaliy.kairachka.todo.service;

import com.vitaliy.kairachka.todo.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * User service
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 16.06.2022
 */
public interface UserService {
    /**
     * Get user by id
     *
     * @param id user
     * @return user entity
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 16.06.2022
     */
    UserEntity getUserById(Long id);

    /**
     * Get user by email
     *
     * @param email user
     * @return user entity
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 16.06.2022
     */
    UserEntity getUserByEmail(String email);

    /**
     * Get all users
     *
     * @param pageable user
     * @return Page<UserEntity>
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 16.06.2022
     */
    Page<UserEntity> getAllUsers(Pageable pageable);

    /**
     * Create user
     *
     * @param user entity
     * @return user entity
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 16.06.2022
     */
    UserEntity createUser(UserEntity user);

    /**
     * Update user
     *
     * @param id   user
     * @param user entity
     * @return user entity
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 16.06.2022
     */
    UserEntity updateUser(Long id, UserEntity user);

    /**
     * Delete user
     *
     * @param id user
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 16.06.2022
     */
    void deleteUser(Long id);
}
