package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;

import java.time.LocalDate;

public class WordDTO {
    private String term;
    private String translation;
    private String example;
    private LocalDate inputDate;
    private Language languages;
    private User addedBy;

    public static WordDTO createWord (Word word) {
        WordDTO wordDTO = new WordDTO();
        wordDTO.term = word.getTerm();
        wordDTO.translation = word.getTranslation();
        wordDTO.example = word.getExample();
        wordDTO.inputDate = word.getInputDate();
        wordDTO.languages = word.getLanguage();
        wordDTO.addedBy = word.getAddedBy();
        return wordDTO;
    }

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

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }

    public Language getLanguages() {
        return languages;
    }

    public void setLanguages(Language languages) {
        this.languages = languages;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }
}
