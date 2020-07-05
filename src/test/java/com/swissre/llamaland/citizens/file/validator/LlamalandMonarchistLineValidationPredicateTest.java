package com.swissre.llamaland.citizens.file.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LlamalandMonarchistLineValidationPredicateTest {

    private LlamalandMonarchistLineValidationPredicate validationPredicate;

    @BeforeEach
    public void setUp() {
        validationPredicate = new LlamalandMonarchistLineValidationPredicate();
    }

    @Test
    public void givenValidLine_whenTest_thenReturnsTrue() {
        assertTrue(validationPredicate.test(asList("Apostol", "Oana", "01-03-2020", "test@email.com")));
    }

    @ParameterizedTest
    @MethodSource
    public void givenInvalidLine_whenTest_thenReturnsFalse(List<String> invalidLine) {
        assertFalse(validationPredicate.test(invalidLine));
    }

    private static Stream<List<String>> givenInvalidLine_whenTest_thenReturnsFalse() {
        return Stream.of(asList("Apostol", "Oana", "2020-05-01"),
                asList("Apostol", "Oana", "2020-05-01", "test@email.com"),
                asList("Apostol", "Oana", "01-05-2020", "invalidEmail"));
    }
}
