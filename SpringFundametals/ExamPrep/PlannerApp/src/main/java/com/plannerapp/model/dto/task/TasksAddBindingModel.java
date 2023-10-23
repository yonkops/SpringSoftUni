package com.plannerapp.model.dto.task;

import com.plannerapp.model.annotation.StringDateInFuture;
import com.plannerapp.model.enums.PriorityName;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TasksAddBindingModel {

    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters!")
    private String description;

   /* @StringDateInFuture(message = "Due Date must be in the future!")
    private String dueDate;*/
    @NotNull(message = "Due Date must be in the future!")
    @Future(message = "Due Date must be in the future!")
    private LocalDate dueDate;

    @NotNull(message = "You must select a priority!")
    private PriorityName priority;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate  getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate  dueDate) {
        this.dueDate = dueDate;
    }

    public PriorityName getPriority() {
        return priority;
    }

    public void setPriority(PriorityName priority) {
        this.priority = priority;
    }
}