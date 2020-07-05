package com.swissre.llamaland.citizens.file.validator;

import java.util.List;
import java.util.function.Predicate;

public class LlamalandNonMonarchistLineValidator implements Predicate<List<String>> {

    private static final Integer NO_OF_COLUMNS = 1;

    @Override
    public boolean test(List<String> line) {
        return new LineSizeValidator(NO_OF_COLUMNS).test(line)
                && new EmailValidator().test(line.get(0));
    }
}
