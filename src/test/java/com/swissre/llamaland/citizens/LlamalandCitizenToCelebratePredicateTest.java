package com.swissre.llamaland.citizens;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static java.time.LocalDate.of;
import static java.time.Month.JULY;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LlamalandCitizenToCelebratePredicateTest {

    @ParameterizedTest
    @MethodSource
    public void givenLlamalandCitizenToCelebrateAndFromDateIsWeekday_whenTest_thenReturnsTrue(LocalDate dateOfBirth) {
        LlamalandCitizenToCelebratePredicate llamalandCitizenToCelebratePredicate = new LlamalandCitizenToCelebratePredicate(of(2020, JULY, 3), 5);

        boolean result = llamalandCitizenToCelebratePredicate.test(new LlamalandCitizenBuilder()
                .setDateOfBirth(dateOfBirth)
                .build());

        assertTrue(result);
    }

    private static Stream<LocalDate> givenLlamalandCitizenToCelebrateAndFromDateIsWeekday_whenTest_thenReturnsTrue() {
        return Stream.of(of(1920, JULY, 10),
                of(1920, JULY, 11),
                of(1920, JULY, 12));
    }

    @Test
    public void givenLlamalandCitizenToCelebrateAndFromDateIsWeekend_whenTest_thenReturnsTrue() {
        LlamalandCitizenToCelebratePredicate llamalandCitizenToCelebratePredicate = new LlamalandCitizenToCelebratePredicate(of(2020, JULY, 5), 5);

        boolean result = llamalandCitizenToCelebratePredicate.test(new LlamalandCitizenBuilder()
                .setDateOfBirth(of(1920, JULY, 13))
                .build());

        assertTrue(result);
    }

    @Test
    public void givenLlamalandCitizenNotYetToCelebrate_whenTest_thenReturnsFalse() {
        LlamalandCitizenToCelebratePredicate llamalandCitizenToCelebratePredicate = new LlamalandCitizenToCelebratePredicate(of(2020, JULY, 5), 3);

        boolean result = llamalandCitizenToCelebratePredicate.test(new LlamalandCitizenBuilder()
                .setDateOfBirth(of(1920, JULY, 13))
                .build());

        assertFalse(result);
    }

    @Test
    public void givenLlamalandCitizenNonMonarchist_whenTest_thenReturnsFalse() {
        LlamalandCitizenToCelebratePredicate llamalandCitizenToCelebratePredicate = new LlamalandCitizenToCelebratePredicate(of(2020, JULY, 5), 3);

        boolean result = llamalandCitizenToCelebratePredicate.test(new LlamalandCitizenBuilder().build());

        assertFalse(result);
    }

}
