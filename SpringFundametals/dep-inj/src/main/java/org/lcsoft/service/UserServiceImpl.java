package org.lcsoft.service;

import org.lcsoft.model.User;
import org.lcsoft.repository.InMemoryUserRepository;
import org.lcsoft.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> findYoungestUser() {
        return userRepository.findAll()
                .stream()
                .min(Comparator.comparingInt(User::age));
    }
}
