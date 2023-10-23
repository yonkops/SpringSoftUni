package com.lcsoft.pathfinder.model.entity;

import com.lcsoft.pathfinder.model.enums.UserRoles;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRoles name;

    public Role() {
    }

    public UserRoles getName() {
        return name;
    }

    public void setName(UserRoles name) {
        this.name = name;
    }
}
