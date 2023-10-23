package com.lcsoft.pathfinder.controller;

import com.lcsoft.pathfinder.model.entity.User;
import com.lcsoft.pathfinder.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/all")
    public List<User> getAll() {
        return this.userService.getAll();
    }
}
