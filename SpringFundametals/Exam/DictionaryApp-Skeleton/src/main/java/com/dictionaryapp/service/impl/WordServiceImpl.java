package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.WordAddBindingModel;
import com.dictionaryapp.model.dto.WordDTO;
import com.dictionaryapp.model.dto.WordHomeView;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;
    private final LanguageRepository languageRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public WordServiceImpl(WordRepository wordRepository,
                           LanguageRepository languageRepository,
                           UserRepository userRepository, LoggedUser loggedUser) {
        this.wordRepository = wordRepository;
        this.languageRepository = languageRepository;
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public void add(WordAddBindingModel wordAddBindingModel, LoggedUser loggedUser) {
        Language language = languageRepository.findByName(wordAddBindingModel.getLanguage());
        User user = userRepository.findByUsername(loggedUser.getUsername());
        if (language != null) {
            Word word = new Word();
            word.setTerm(wordAddBindingModel.getTerm());
            word.setTranslation(wordAddBindingModel.getTranslation());
            word.setExample(wordAddBindingModel.getExample());
            word.setInputDate(wordAddBindingModel.getInputDate());
            word.setAddedBy(user);
            wordRepository.save(word);
        }

    }

    @Override
    public void remove(Long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        wordRepository.deleteAll();
    }

    @Override
    public WordHomeView getHomeViewByLanguage(Language language) {
        List<WordDTO> wordByLanguage = wordRepository.findByLanguage(language)
                .stream().map(WordDTO::createWord)
                .toList();

        return new WordHomeView(wordByLanguage);
    }


}
