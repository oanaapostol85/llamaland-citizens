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
    public void givenValidDateFormat_whenTest_thenReturnsTrue() {
        assertTrue(validator.test("10-05-2020"));
    }

    @Test
    public void givenInvalidDateFormat_whenTest_thenReturnsFalse() {
        assertFalse(validator.test("2020-05-10"));
    }
}
