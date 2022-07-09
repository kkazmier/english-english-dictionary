package com.englishenglishdictionary.client;

import com.englishenglishdictionary.model.WordnikDictionaryWordDefinition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class WordnikDictionaryClient {
    public static final Logger logger = LoggerFactory.getLogger(WordnikDictionaryClient.class);
    @Value("${wordnikdictionary_endpoint}")
    private String wordnikDictionaryEndpoint;
    @Value("${wordnikdictionary_key}")
    private String wordnikApiKey;

    private RestTemplate restTemplate;

    @Autowired
    public WordnikDictionaryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Collection<WordnikDictionaryWordDefinition> getDefinitions(String word) throws JsonProcessingException {
        String url = wordnikDictionaryEndpoint + "/" + word + "/" + "definitions" + "?api_key=" + wordnikApiKey;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        logger.info("Request status code: " + response.getStatusCode());
        Type definitionsCollectionType = new TypeToken<ArrayList<WordnikDictionaryWordDefinition>>() { }.getType();
        if (response.getStatusCode() == HttpStatus.OK) {
            Collection<WordnikDictionaryWordDefinition> definitions = new Gson().fromJson(
                    response.getBody(), definitionsCollectionType);
            return definitions;
        } else {
            return new ArrayList<>();
        }
    }
}
