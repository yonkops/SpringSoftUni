package org.lcsoft.repository;

import org.lcsoft.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryUserRepository implements UserRepository{
    @Override
    public List<User> findAll() {
        return List.of(
                new User("Ivan", "Ivanov", 20),
                new User("Georgi", "Georgiev", 30),
                new User("Petar", "Petrov", 40)
        );
    }
}
