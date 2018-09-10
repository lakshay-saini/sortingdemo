package com.teigentech.sortingapplication;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparingLong;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

class InputReader {

    private static final String FILE_NAME = "/sample.txt";
    private static final String REGEX = "\\r\\n|\\r|\\n|[^a-zA-Z0-9]";

    /**
     * This method is used to read string from file and
     *  provide the map which contains words appears in file and their iteration count
     */

    public Map<String, Long> readInputFile(){
        InputStream inputStream = InputReader.class.getResourceAsStream(FILE_NAME);
        Map<String, Long> wordsWithCount;

        try {
            StringWriter writer = new StringWriter();
            IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8.name());
            String inputString = writer.toString().toLowerCase().replaceAll(REGEX, " ");

            wordsWithCount = Stream.of(StringUtils.split(inputString, " "))
                                .map(w -> w.split(" "))
                                .flatMap(Arrays::stream)
                                .collect(groupingBy(identity(), counting()));

            return wordsWithCount.entrySet().stream()
                    .sorted(Collections.reverseOrder(comparingLong(Map.Entry::getValue)))
                    .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), Map::putAll);


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
