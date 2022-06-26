package com.englishenglishdictionary.controller;


import com.englishenglishdictionary.client.FreeDictionaryClient;
import com.englishenglishdictionary.client.WordnikDictionaryClient;
import com.englishenglishdictionary.model.Word;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
    private FreeDictionaryClient dictionaryClient;
    private WordnikDictionaryClient wordnikDictionaryClient;

    @Autowired
    public WordController(FreeDictionaryClient dictionaryClient, WordnikDictionaryClient wordnikDictionaryClient) {
        this.dictionaryClient = dictionaryClient;
        this.wordnikDictionaryClient = wordnikDictionaryClient;
    }

//    @GetMapping
//    Word getWordFromFreeDictionary(String word) {
//        Word result = new Word();
//
//        return result;
//    }

    @GetMapping("{word}")
    String getWordFromFreeDictionaryString(@PathVariable("word") String word) throws JsonProcessingException {
        return dictionaryClient.getWordFromFreeDictionary(word);
    }

    @GetMapping("wordnikDictionary/{word}")
    String getWordDefinitions(@PathVariable("word") String word) throws JsonProcessingException {
        return wordnikDictionaryClient.getDefinitions(word).toString();
    }
}
