package com.vitaliy.kairachka.todo.repository;

import com.vitaliy.kairachka.todo.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * User repository
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 16.06.2022
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {
    /**
     * Get user entity by email or null if missing
     *
     * @param email user
     * @return optional user entity or null
     * @author Kairachka Vitaliy
     * @version 0.0.1-SNAPSHOT
     * @since 16.06.2022
     */
    Optional<UserEntity> findByEmail(String email);
}
