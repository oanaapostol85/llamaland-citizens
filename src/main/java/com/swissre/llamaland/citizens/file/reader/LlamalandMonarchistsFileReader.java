package com.swissre.llamaland.citizens.file.reader;

import com.swissre.llamaland.citizens.LlamalandCitizen;
import com.swissre.llamaland.citizens.LlamalandCitizenBuilder;
import com.swissre.llamaland.citizens.file.validator.LlamalandMonarchistLineValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LlamalandMonarchistsFileReader implements LlamalandCitizensFileReadable {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public Predicate<List<String>> isValidLine() {
        return new LlamalandMonarchistLineValidator();
    }

    @Override
    public LlamalandCitizen mapLineToLlamalandCitizen(List<String> llamalandCitizenDetails) {
        Iterator<String> llamalandCitizenDetailsIterator = llamalandCitizenDetails.iterator();
        return new LlamalandCitizenBuilder()
                .setLastName(llamalandCitizenDetailsIterator.next())
                .setFirstName(llamalandCitizenDetailsIterator.next())
                .setDateOfBirth(LocalDate.parse(llamalandCitizenDetailsIterator.next(), DATE_TIME_FORMATTER))
                .setEmail(llamalandCitizenDetailsIterator.next())
                .build();
    }
}
