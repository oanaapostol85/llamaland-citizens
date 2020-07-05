package com.swissre.llamaland.citizens;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LlamalandCitizenDuplicateEmailPredicate implements Predicate<LlamalandCitizen> {

    private final List<LlamalandCitizen> llamalandCitizens;

    public LlamalandCitizenDuplicateEmailPredicate(List<LlamalandCitizen> llamalandCitizens) {
        this.llamalandCitizens = llamalandCitizens;
    }

    @Override
    public boolean test(LlamalandCitizen llamalandCitizen) {
        Map<String, Long> emailCounter = llamalandCitizens.stream()
                .collect(groupingBy(LlamalandCitizen::getEmail, counting()));
        return emailCounter.get(llamalandCitizen.getEmail()) > 1;
    }
}
