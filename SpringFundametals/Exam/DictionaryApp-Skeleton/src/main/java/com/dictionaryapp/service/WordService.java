package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.WordAddBindingModel;
import com.dictionaryapp.model.dto.WordHomeView;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.service.impl.LoggedUser;

public interface WordService {
    void add(WordAddBindingModel wordAddBindingModel, LoggedUser loggedUser);

    void remove(Long id);

    void removeAll();

    WordHomeView getHomeViewByLanguage(Language language);
}
