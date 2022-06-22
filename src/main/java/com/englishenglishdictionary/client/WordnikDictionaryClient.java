package com.englishenglishdictionary.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WordnikDictionaryClient {
    @Value("${wordnikdictionary_endpoint}")
    private String wordnikDictionaryEndpoint;

    private RestTemplate restTemplate;

    @Autowired
    public WordnikDictionaryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getDefinitions(String word) throws JsonProcessingException {

    }
}
