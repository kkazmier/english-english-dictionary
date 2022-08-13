package com.edu.englishenglishdictionary.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WordnikDictionaryWordDefinition {
    String text;
    String partOfSpeech;

    @Override
    public String toString() {
        return "WordnikDictionaryWordDefinition{" +
                "text='" + text + '\'' +
                ", partOfSpeech='" + partOfSpeech + '\'' +
                '}';
    }
}
