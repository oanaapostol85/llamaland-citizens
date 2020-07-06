package com.swissre.llamaland.citizens;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LlamalandCitizenDuplicateEmailPredicateTest {

    private static final String UNIQUE_EMAIL = "uniqueEmail@test.com";

    private static final String DUPLICATE_EMAIL = "duplicateEmail@test.com";

    private LlamalandCitizenDuplicateEmailPredicate llamalandCitizenDuplicateEmailPredicate;

    @BeforeEach
    public void setUp() {
        Map<String, Long> emailCounter = new HashMap<>();
        emailCounter.put(UNIQUE_EMAIL, 1L);
        emailCounter.put(DUPLICATE_EMAIL, 2L);
        llamalandCitizenDuplicateEmailPredicate = new LlamalandCitizenDuplicateEmailPredicate(emailCounter);
    }

    @Test
    public void givenLlamalandCitizenWithDuplicateEmail_whenTest_thenReturnsTrue() {

        boolean result = llamalandCitizenDuplicateEmailPredicate.test(new LlamalandCitizenBuilder()
                .setEmail(DUPLICATE_EMAIL)
                .build());

        assertTrue(result);
    }

    @Test
    public void givenLlamalandCitizenWithUniqueEmail_whenTest_thenReturnsFalse() {

        boolean result = llamalandCitizenDuplicateEmailPredicate.test(new LlamalandCitizenBuilder()
                .setEmail(UNIQUE_EMAIL)
                .build());

        assertFalse(result);
    }
}
