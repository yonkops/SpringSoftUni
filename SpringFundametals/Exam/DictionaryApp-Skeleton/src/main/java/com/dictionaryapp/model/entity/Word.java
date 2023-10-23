package com.dictionaryapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "words")
public class Word extends BaseEntity {
    @Column(nullable = false)
    @Size(min = 2, max = 40)
    private String term;
    @Column(nullable = false)
    @Size(min = 2, max = 80)
    private String translation;
    @Column(columnDefinition = "TEXT")
    @Size(min = 2, max = 200)
    private String example;
    @PastOrPresent
    @NotNull
    private LocalDate inputDate;
    @ManyToOne
    @NotNull
    private Language language;
    @ManyToOne
    private User addedBy;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate date) {
        this.inputDate = date;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language languages) {
        this.language = languages;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }
}
