package com.swissre.llamaland.citizens.file.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LlamalandNonMonarchistLineValidationPredicateTest {

    private LlamalandNonMonarchistLineValidationPredicate validationPredicate;

    @BeforeEach
    public void setUp() {
        validationPredicate = new LlamalandNonMonarchistLineValidationPredicate();
    }

    @Test
    public void givenValidLine_whenTest_thenReturnsTrue() {
        assertTrue(validationPredicate.test(singletonList("test@email.com")));
    }

    @ParameterizedTest
    @MethodSource
    public void givenInvalidLine_whenTest_thenReturnsFalse(List<String> invalidLine) {
        assertFalse(validationPredicate.test(invalidLine));
    }

    private static Stream<List<String>> givenInvalidLine_whenTest_thenReturnsFalse() {
        return Stream.of(asList("Apostol", "Oana", "test@email.com"),
                singletonList("test@email"));
    }
}
