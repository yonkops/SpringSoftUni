package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.WordAddBindingModel;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.service.impl.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordController {
    private final WordService wordService;
    private final LoggedUser loggedUser;

    public WordController(WordService wordService, LoggedUser loggedUser) {
        this.wordService = wordService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/words/add")
    public ModelAndView add(@ModelAttribute("wordAddBindingModel") WordAddBindingModel wordAddBindingModel) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/index");
        }

        return new ModelAndView("word-add");
    }

    @PostMapping("/words/add")
    public ModelAndView add(@ModelAttribute("wordAddBindingModel")
                                @Valid WordAddBindingModel wordAddBindingModel,
                            BindingResult bindingResult) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/index");
        }
        if (bindingResult.hasErrors()) {
            return new ModelAndView("word-add");
        }
        wordService.add(wordAddBindingModel, loggedUser);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/words/remove/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/index");
        }
        wordService.remove(id);
        return new ModelAndView("redirect:/home");
    }

    @PostMapping("/words/removeAll")
    public ModelAndView removeAll() {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/index");
        }
        wordService.removeAll();
        return new ModelAndView("redirect:/home");
    }
}
