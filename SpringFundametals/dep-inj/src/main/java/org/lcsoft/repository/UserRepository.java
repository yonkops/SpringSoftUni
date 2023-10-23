package org.lcsoft.repository;

import org.lcsoft.model.User;

import java.util.List;

public interface UserRepository  {
    List<User> findAll();
}
