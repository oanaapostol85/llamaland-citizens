package com.swissre.llamaland.citizens;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.time.LocalDate.of;
import static java.time.Month.JULY;
import static org.junit.jupiter.api.Assertions.*;

public class LlamalandCitizenToCelebrateFinderTest {

    @Test
    public void givenLlamalandCitizenToCelebrateWithDuplicateEmail_whenFindLlamalandCitizensToCelebrate_thenDuplicateEmailsAreFilteredOut() {
        LlamalandCitizensToCelebrateFinder llamalandCitizenToCelebrateFinder = new LlamalandCitizensToCelebrateFinder() {
            @Override
            List<LlamalandCitizen> getLlamalandCitizens() {
                final String duplicateEmail = "duplicateEmail@test.com";

                List<LlamalandCitizen> llamalandCitizens = new ArrayList<>();

                llamalandCitizens.add(new LlamalandCitizenBuilder()
                        .setEmail(duplicateEmail)
                        .setDateOfBirth(of(1920, JULY, 3))
                        .build());

                llamalandCitizens.add(new LlamalandCitizenBuilder()
                        .setEmail(duplicateEmail)
                        .build());

                return llamalandCitizens;
            }

            @Override
            LocalDate fromDate() {
                return of(2020, JULY, 3);
            }
        };

        llamalandCitizenToCelebrateFinder.findLlamalandCitizensToCelebrate();

        assertTrue(llamalandCitizenToCelebrateFinder.getLlamalandCitizensToCelebrate().isEmpty());
    }

    @Test
    public void givenLlamalandCitizenToCelebrateWithUniqueEmail_whenFindLlamalandCitizensToCelebrate_thenLlamalandCitizensToCelebrateIsReturned() {
        final String email = "uniqueEmail@test.com";

        LlamalandCitizensToCelebrateFinder llamalandCitizenToCelebrateFinder = new LlamalandCitizensToCelebrateFinder() {
            @Override
            List<LlamalandCitizen> getLlamalandCitizens() {
                List<LlamalandCitizen> llamalandCitizens = new ArrayList<>();

                llamalandCitizens.add(new LlamalandCitizenBuilder()
                        .setEmail(email)
                        .setDateOfBirth(of(1920, JULY, 10))
                        .build());

                llamalandCitizens.add(new LlamalandCitizenBuilder()
                        .setEmail("secondUniqueEmail@test.com")
                        .build());

                return llamalandCitizens;
            }

            @Override
            LocalDate fromDate() {
                return of(2020, JULY, 3);
            }
        };

        llamalandCitizenToCelebrateFinder.findLlamalandCitizensToCelebrate();

        assertFalse(llamalandCitizenToCelebrateFinder.getLlamalandCitizensToCelebrate().isEmpty());
        assertEquals(1, llamalandCitizenToCelebrateFinder.getLlamalandCitizensToCelebrate().size());
        assertEquals(email, llamalandCitizenToCelebrateFinder.getLlamalandCitizensToCelebrate().get(0).getEmail());
    }

    @Test
    public void givenMoreThan20LlamalandCitizensToCelebrateIn10Days_whenFindLlamalandCitizensToCelebrate_thenLlamalandCitizensToCelebrateAreReturned() {
        LlamalandCitizensToCelebrateFinder llamalandCitizenToCelebrateFinder = new LlamalandCitizensToCelebrateFinder() {
            @Override
            List<LlamalandCitizen> getLlamalandCitizens() {
                return IntStream.range(0, 25)
                        .mapToObj(i -> new LlamalandCitizenBuilder()
                                .setEmail(format("uniqueEmail%d@test.com", i))
                                .setDateOfBirth(of(1920, JULY, 17))
                                .build())
                        .collect(Collectors.toList());
            }

            @Override
            LocalDate fromDate() {
                return of(2020, JULY, 3);
            }
        };

        llamalandCitizenToCelebrateFinder.findLlamalandCitizensToCelebrate();

        assertFalse(llamalandCitizenToCelebrateFinder.getLlamalandCitizensToCelebrate().isEmpty());
        assertEquals(25, llamalandCitizenToCelebrateFinder.getLlamalandCitizensToCelebrate().size());
    }
}
