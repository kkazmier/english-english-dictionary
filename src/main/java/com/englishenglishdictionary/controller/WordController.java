package com.englishenglishdictionary.controller;


import com.englishenglishdictionary.client.FreeDictionaryClient;
import com.englishenglishdictionary.model.Word;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
    private FreeDictionaryClient dictionaryClient;

    @Autowired
    public WordController(FreeDictionaryClient dictionaryClient) {
        this.dictionaryClient = dictionaryClient;
    }

    @GetMapping
    Word getWordFromFreeDictionary(String word) {
        Word result = new Word();

        return result;
    }

    @GetMapping("{word}")
    String getWordFromFreeDictionaryString(@PathVariable("word") String word) throws JsonProcessingException {
        return dictionaryClient.getWordFromFreeDictionary(word);
    }
}
