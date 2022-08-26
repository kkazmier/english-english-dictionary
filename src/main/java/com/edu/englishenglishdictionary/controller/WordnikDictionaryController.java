package com.edu.englishenglishdictionary.controller;

import com.edu.englishenglishdictionary.client.WordnikDictionaryClient;
import com.edu.englishenglishdictionary.model.Word;
import com.edu.englishenglishdictionary.model.WordnikDictionaryWordDefinition;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/definitions")
    public String wordDefinitionsSubmit(@ModelAttribute("word") Word word, Model model) throws JsonProcessingException {
        logger.info("submit " + word.getWord() + " definition");
        Collection<WordnikDictionaryWordDefinition> wordDefinitions = wordnikDictionaryClient.getDefinitions(word.getWord());
        List<String> definitions = wordDefinitions.stream()
                .filter(e -> e.getText() != null)
                .map(def -> def.getText())
                .collect(Collectors.toList());
        model.addAttribute("definitions", definitions);
        return "wordnik-dictionary-definitions";
    }
}
