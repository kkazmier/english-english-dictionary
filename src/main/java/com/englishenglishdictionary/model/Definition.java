package com.englishenglishdictionary.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Definition {
    private String partOfSpeech;
    private List<String> definitions;
}
