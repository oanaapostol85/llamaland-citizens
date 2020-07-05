package com.swissre.llamaland.citizens.file.validator;

import java.util.List;
import java.util.function.Predicate;

public class LineSizeValidator implements Predicate<List<String>> {

    private final Integer size;

    public LineSizeValidator(Integer size) {
        this.size = size;
    }

    @Override
    public boolean test(List<String> line) {
        boolean validLineSize = size.equals(line.size());
        if (!validLineSize) {
            System.err.printf("Invalid line %s! Expected size: %d\n", line, size);
        }
        return validLineSize;
    }
}
