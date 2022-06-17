package com.vitaliy.kairachka.todo.service.impl;

import com.vitaliy.kairachka.todo.model.entity.UserEntity;
import com.vitaliy.kairachka.todo.model.enums.user.Role;
import com.vitaliy.kairachka.todo.model.mapper.UserMapper;
import com.vitaliy.kairachka.todo.repository.UserRepository;
import com.vitaliy.kairachka.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User service implementation
 *
 * @author Kairachka Vitaliy
 * @version 0.0.1-SNAPSHOT
 * @since 17.06.2022
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> {
            //TODO exception
            return null;
        });
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> {
            //TODO exception
            return null;
        });
    }

    @Override
    public Page<UserEntity> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public UserEntity updateUser(Long id, UserEntity user) {
        UserEntity target = this.getUserById(id);
        target = userMapper.merge(user, target);
        target.setRole(Role.USER);
        return userRepository.save(target);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        this.getUserById(id);
        userRepository.deleteById(id);
    }
}
