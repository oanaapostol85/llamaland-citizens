package com.swissre.llamaland.citizens;

import java.time.LocalDate;

public class LlamalandCitizenBuilder {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;

    public LlamalandCitizenBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public LlamalandCitizenBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LlamalandCitizenBuilder setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public LlamalandCitizenBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public LlamalandCitizen build() {
        LlamalandCitizen llamalandCitizen = new LlamalandCitizen();
        llamalandCitizen.setFirstName(firstName);
        llamalandCitizen.setLastName(lastName);
        llamalandCitizen.setDateOfBirth(dateOfBirth);
        llamalandCitizen.setEmail(email);

        return llamalandCitizen;
    }
}