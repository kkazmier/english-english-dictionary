package com.edu.englishenglishdictionary.controller;

import com.edu.englishenglishdictionary.client.WordnikDictionaryClient;
import com.edu.englishenglishdictionary.model.WordnikDictionaryWordDefinition;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/wordnikDictionary")
public class WordnikDictionaryController {
    public static final Logger logger = LoggerFactory.getLogger(WordnikDictionaryController.class);
    private final WordnikDictionaryClient wordnikDictionaryClient;

    @Autowired
    public WordnikDictionaryController(WordnikDictionaryClient wordnikDictionaryClient) {
        this.wordnikDictionaryClient = wordnikDictionaryClient;
    }

    @GetMapping("/definitions/{word}")
    String wordDefinitions(@PathVariable("word") String word, Model model) throws JsonProcessingException {
        logger.info("Search defs for: " + word);
        Collection<WordnikDictionaryWordDefinition> wordDefinitions = wordnikDictionaryClient.getDefinitions(word);
        List<String> definitions = wordDefinitions.stream().map(
                def -> def.getText()).collect(Collectors.toList());
        model.addAttribute("definitions", definitions);
        return "wordnik-dictionary-definitions";
    }
}
