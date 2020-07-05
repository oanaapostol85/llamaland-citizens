package com.swissre.llamaland.citizens.file.validator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.function.Predicate;

import static com.swissre.llamaland.citizens.file.reader.LlamalandMonarchistsFileReader.DATE_TIME_FORMATTER;

public class DateOfBirthValidator implements Predicate<String> {

    @Override
    public boolean test(String dateOfBirth) {
        try {
            LocalDate.parse(dateOfBirth, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            System.err.printf("Invalid dateOfBirth format %s! dd-MM-yyyy is expected!\n", dateOfBirth);
            return false;
        }

        return true;
    }
}
