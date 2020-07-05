package com.swissre.llamaland.citizens.file.validator;

import java.util.List;
import java.util.function.Predicate;

public class LlamalandMonarchistLineValidator implements Predicate<List<String>> {

    private static final Integer NO_OF_COLUMNS = 4;

    @Override
    public boolean test(List<String> line) {
        return new LineSizeValidator(NO_OF_COLUMNS).test(line)
                && new DateOfBirthValidator().test(line.get(2))
                && new EmailValidator().test(line.get(3));
    }
}
