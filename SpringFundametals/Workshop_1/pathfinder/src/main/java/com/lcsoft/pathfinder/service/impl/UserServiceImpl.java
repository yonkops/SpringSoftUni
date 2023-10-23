package com.lcsoft.pathfinder.service.impl;

import com.lcsoft.pathfinder.model.entity.User;
import com.lcsoft.pathfinder.repository.UserRepository;
import com.lcsoft.pathfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
