package com.swissre.llamaland.citizens.file.validator;

import java.util.List;

public class LineSizeValidator implements Validator<List<String>> {

    private final Integer size;

    public LineSizeValidator(Integer size) {
        this.size = size;
    }

    @Override
    public boolean isValid(List<String> line) {
        boolean validLineSize = size.equals(line.size());
        if (!validLineSize) {
            System.err.printf("Invalid line %s! Expected size: %d\n", line, size);
        }
        return validLineSize;
    }
}
