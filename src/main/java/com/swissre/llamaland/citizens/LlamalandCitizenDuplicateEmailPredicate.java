package com.swissre.llamaland.citizens;

import java.util.Map;
import java.util.function.Predicate;

public class LlamalandCitizenDuplicateEmailPredicate implements Predicate<LlamalandCitizen> {

    private final Map<String, Long> emailCounter;

    public LlamalandCitizenDuplicateEmailPredicate(Map<String, Long> emailCounter) {
        this.emailCounter = emailCounter;
    }

    @Override
    public boolean test(LlamalandCitizen llamalandCitizen) {
        return emailCounter.get(llamalandCitizen.getEmail()) > 1;
    }
}
