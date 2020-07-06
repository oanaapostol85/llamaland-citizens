package com.swissre.llamaland.citizens.file.reader;

import com.swissre.llamaland.citizens.LlamalandCitizen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public interface LlamalandCitizensFileReadable {

    Pattern DELIMITER = Pattern.compile(",");

    LlamalandCitizen mapLineToLlamalandCitizen(List<String> llamalandCitizenDetails);

    Predicate<List<String>> isValidLine();

    default List<LlamalandCitizen> readFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath))
                    .stream()
                    .filter(line -> line != null && !line.isEmpty())
                    .map(line -> asList(DELIMITER.split(line)))
                    .filter(isValidLine())
                    .map(this::mapLineToLlamalandCitizen)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.printf("Unable to read %s file!\n", filePath);
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
