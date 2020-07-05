package com.swissre.llamaland.citizens.file.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {

    private EmailValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new EmailValidator();
    }

    @Test
    public void givenValidEmail_whenTest_thenReturnsTrue() {
        assertTrue(validator.test("valid@test.com"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid", "@test.com", "invalid@test"})
    public void givenInvalidEmail_whenTest_thenReturnsFalse(String invalidEmail) {
        assertFalse(validator.test(invalidEmail));
    }
}
