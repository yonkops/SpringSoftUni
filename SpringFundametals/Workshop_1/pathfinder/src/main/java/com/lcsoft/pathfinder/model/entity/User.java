package com.lcsoft.pathfinder.model.entity;

import com.lcsoft.pathfinder.model.enums.UserLevel;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "users")
public class User extends BaseEntity {
    private String username;
    private int age;
    private String password;
    private String fullName;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @Enumerated(EnumType.STRING)
    private UserLevel level;

    public User() {
        this.roles = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> role) {
        this.roles = role;
    }

    public UserLevel getLevel() {
        return level;
    }

    public void setLevel(UserLevel level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
/*username - Accepts String values

o Accepts values, which should be at least 2 characters

· password - Accepts String values

o Accepts values, which should be at least 2 characters

· full name - Accepts String values

o Accepts values, which should be at least 2 characters

· email - Accepts String values

o Accepts values, which contain the '@' symbol

· role - Accepts Role Entity values

o Each registered user should have a "User" role

· level - Accepts a level of the user (BEGINNER, INTERMEDIATE, ADVANCED)*/