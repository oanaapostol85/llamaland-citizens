package com.swissre.llamaland.citizens.file.reader;

import com.swissre.llamaland.citizens.LlamalandCitizen;
import com.swissre.llamaland.citizens.LlamalandCitizenBuilder;
import com.swissre.llamaland.citizens.file.validator.LlamalandNonMonarchistLineValidationPredicate;

import java.util.List;
import java.util.function.Predicate;

public class LlamalandNonMonarchistsFileReader implements LlamalandCitizensFileReadable {

    @Override
    public Predicate<List<String>> isValidLine() {
        return new LlamalandNonMonarchistLineValidationPredicate();
    }

    @Override
    public LlamalandCitizen mapLineToLlamalandCitizen(List<String> llamalandCitizenDetails) {
        return new LlamalandCitizenBuilder()
                .setEmail(llamalandCitizenDetails.get(0))
                .build();
    }
}
