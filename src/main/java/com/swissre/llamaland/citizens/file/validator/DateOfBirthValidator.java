package com.swissre.llamaland.citizens.file.validator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static com.swissre.llamaland.citizens.file.reader.LlamalandMonarchistsFileReader.DATE_TIME_FORMATTER;

public class DateOfBirthValidator implements Validator<String> {

    @Override
    public boolean isValid(String dateOfBirth) {
        try {
            LocalDate.parse(dateOfBirth, DATE_TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            System.err.printf("Invalid dateOfBirth format %s! dd-MM-yyyy is expected!\n", dateOfBirth);
            return false;
        }

        return true;
    }
}
