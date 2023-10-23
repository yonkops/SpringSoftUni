package org.lcsoft.service;

import org.lcsoft.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findYoungestUser();
}
