package com.plannerapp.service;

import com.plannerapp.model.dto.user.UserLoginBindingModel;
import com.plannerapp.model.dto.user.UserRegisterBindingModel;

public interface UserService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    void logout();

    boolean login(UserLoginBindingModel userLoginBindingModel);
}
