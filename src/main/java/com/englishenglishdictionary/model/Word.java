package com.englishenglishdictionary.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Word {
    private String phonetic;
    private String audioUrl;
    private List<String> synonyms;
    private List<Definition> definitions;
    private List<String> examples;

    @Override
    public String toString() {
        return "Word{" +
                "phonetic='" + phonetic + '\'' +
                ", audioUrl='" + audioUrl + '\'' +
                ", synonyms=" + synonyms +
                ", definitions=" + definitions +
                ", examples=" + examples +
                '}';
    }
}
