package com.swissre.llamaland.citizens.file.validator;

public interface Validator<T> {

    boolean isValid(T value);
}
