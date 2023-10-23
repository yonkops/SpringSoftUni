package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionName;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private ConditionName conditionName;

    @NotNull
    private String description;

    public ConditionName getConditionName() {
        return conditionName;
    }

    public void setConditionName(ConditionName conditionName) {
        this.conditionName = conditionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(ConditionName conditionName) {
        this.description = conditionName.getValue();
    }
}
