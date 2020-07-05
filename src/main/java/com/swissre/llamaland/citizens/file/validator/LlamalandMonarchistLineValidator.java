package com.swissre.llamaland.citizens.file.validator;

import java.util.List;
import java.util.function.Predicate;

public class LlamalandMonarchistLineValidator implements Predicate<List<String>> {

    private static final Integer NO_OF_COLUMNS = 4;

    @Override
    public boolean test(List<String> line) {
        return new LineSizeValidator(NO_OF_COLUMNS).isValid(line)
                && new DateOfBirthValidator().isValid(line.get(2))
                && new EmailValidator().isValid(line.get(3));
    }
}
