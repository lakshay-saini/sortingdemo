package com.teigentech.sortingapplication;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


class SortingOperation {

    private Map<String, Long> wordsWithCount;

    public SortingOperation() {
        this.wordsWithCount = new InputReader().readInputFile();
    }

    /**
     * This method collect similar words from inputFile and
     *  sorting ascending on the basis of word iteration count
     */
    public List<String> sortInput(String input){

        return wordsWithCount.entrySet()
                    .stream()
                    .filter(entry -> StringUtils.startsWith(entry.getKey(), input))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

    }
}
