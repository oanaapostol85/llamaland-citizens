package com.swissre.llamaland.citizens.file.validator;

import java.util.List;
import java.util.function.Predicate;

public class LlamalandNonMonarchistLineValidationPredicate implements Predicate<List<String>> {

    private static final Integer NO_OF_COLUMNS = 1;

    @Override
    public boolean test(List<String> line) {
        return new LineSizeValidator(NO_OF_COLUMNS).isValid(line)
                && new EmailValidator().isValid(line.get(0));
    }
}
