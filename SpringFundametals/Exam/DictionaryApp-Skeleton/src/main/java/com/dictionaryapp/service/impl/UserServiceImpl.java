package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.UserLoginBindingModel;
import com.dictionaryapp.model.dto.UserRegisterBindingModel;
import com.dictionaryapp.model.dto.WordDTO;
import com.dictionaryapp.model.dto.WordHomeView;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        if (userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            User userOrEmailExist = userRepository.findByUsernameOrEmail(
                    userRegisterBindingModel.getUsername(),
                    userRegisterBindingModel.getEmail());
            if (userOrEmailExist == null) {
                User user = new User();
                user.setUsername(userRegisterBindingModel.getUsername());
                user.setEmail(userRegisterBindingModel.getEmail());
                user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();
        User user = userRepository.findByUsername(username);
        boolean matches = passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword());
        if (user != null
                && passwordEncoder.matches(userLoginBindingModel.getPassword(), user.getPassword())) {
            loggedUser.login(username);
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }

}
