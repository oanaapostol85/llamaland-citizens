package com.swissre.llamaland.citizens.file.validator;

import java.util.function.Predicate;

import static java.util.regex.Pattern.compile;

public class EmailValidator implements Predicate<String> {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    @Override
    public boolean test(String email) {
        boolean validEmail = compile(EMAIL_REGEX).matcher(email).matches();
        if (!validEmail) {
            System.err.printf("Invalid email %s!\n", email);
        }
        return validEmail;
    }
}
