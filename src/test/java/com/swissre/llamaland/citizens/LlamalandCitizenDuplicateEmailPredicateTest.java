package com.swissre.llamaland.citizens;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LlamalandCitizenDuplicateEmailPredicateTest {

    private static final String UNIQUE_EMAIL = "uniqueEmail@test.com";

    private static final String DUPLICATE_EMAIL = "duplicateEmail@test.com";

    private LlamalandCitizenDuplicateEmailPredicate llamalandCitizenDuplicateEmailPredicate;

    @BeforeEach
    public void setUp() {
        LlamalandCitizen llamalandCitizen1 = new LlamalandCitizenBuilder()
                .setEmail(UNIQUE_EMAIL)
                .build();
        LlamalandCitizen llamalandCitizen2 = new LlamalandCitizenBuilder()
                .setEmail(DUPLICATE_EMAIL)
                .build();
        LlamalandCitizen llamalandCitizen3 = new LlamalandCitizenBuilder()
                .setEmail(DUPLICATE_EMAIL)
                .build();
        llamalandCitizenDuplicateEmailPredicate = new LlamalandCitizenDuplicateEmailPredicate(asList(llamalandCitizen1, llamalandCitizen2, llamalandCitizen3));
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
