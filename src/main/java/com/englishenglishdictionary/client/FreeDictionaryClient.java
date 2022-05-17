package com.englishenglishdictionary.client;

import com.englishenglishdictionary.model.Word;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FreeDictionaryClient {
    private static final Logger logger = LoggerFactory.getLogger(FreeDictionaryClient.class);
    @Value("${freedictionary_endpoint}")
    private String freedictionary_endpoint;
    private RestTemplate restTemplate;

    @Autowired
    public FreeDictionaryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWordFromFreeDictionary(String word) throws JsonProcessingException {
        ResponseEntity<String> response = restTemplate.getForEntity(freedictionary_endpoint + word, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNodeObj = objectMapper.readValue(response.getBody(), JsonNode.class);
        JsonNode meanings = jsonNodeObj.findValue("meanings");
        List<JsonNode> definitions = meanings.findValues("definition");
        List<JsonNode> synonyms = meanings.findValues("synonyms");
        List<JsonNode> examples = meanings.findValues("example");
        logger.info("synonyms: " + synonyms.toString());
        logger.info("examples: " + examples.toString());
        logger.info("definitions: " + definitions.toString());
        Word wordResult = new Word();

        //logger.info(meanings.asText());
        logger.info(wordResult.toString());
        return wordResult.toString();
    }


}
