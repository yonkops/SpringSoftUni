package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityName;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "priorities")
public class Priority extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private PriorityName name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "priority")
    private Set<Task> tasks;

    private void setDescription(PriorityName name) {
        setDescription(name.getValue());
        /*String description = "";
        switch (name) {
            case URGENT -> description = "An urgent problem that blocks the system use until the issue is resolved.";
            case IMPORTANT -> description = "A core functionality that your product is explicitly supposed to perform is compromised.";
            case LOW -> description = "Should be fixed if time permits but can be postponed.";
        }
        setDescription(description);*/
    }

    public PriorityName getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(PriorityName name) {
        this.name = name;
        setDescription(name);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
