package com.swissre.llamaland.citizens.file.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineSizeValidatorTest {

    private LineSizeValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new LineSizeValidator(2);
    }

    @Test
    public void givenValidLineSize_whenIsValid_thenReturnsTrue() {
        assertTrue(validator.isValid(asList("foo", "bar")));
    }

    @Test
    public void givenInvalidLineSize_whenIsValid_thenReturnsFalse() {
        assertFalse(validator.isValid(singletonList("foo")));
    }
}
