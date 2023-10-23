package com.dictionaryapp.model.dto;

import java.util.List;

public class WordHomeView {
    private List<WordDTO> wordDTOList;
    private int size;


    public WordHomeView(List<WordDTO> wordDTOList) {
        this.wordDTOList = wordDTOList;
        this.size = wordDTOList.size();
    }
}
