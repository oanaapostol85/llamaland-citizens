package com.swissre.llamaland.citizens.file.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DateOfBirthValidatorTest {

    private DateOfBirthValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new DateOfBirthValidator();
    }

    @Test
    public void givenValidDateFormat_whenIsValid_thenReturnsTrue() {
        assertTrue(validator.isValid("10-05-2020"));
    }

    @Test
    public void givenInvalidDateFormat_whenIsValid_thenReturnsFalse() {
        assertFalse(validator.isValid("2020-05-10"));
    }
}
