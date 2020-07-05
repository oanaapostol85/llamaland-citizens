package com.swissre.llamaland.citizens;

import com.swissre.llamaland.citizens.file.reader.LlamalandMonarchistsFileReader;
import com.swissre.llamaland.citizens.file.reader.LlamalandNonMonarchistsFileReader;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.now;
import static java.util.stream.Collectors.toList;

public class LlamalandCitizensToCelebrateFinder {

    private String monarchistsFilePath;

    private String nonMonarchistsFilePath;

    private List<LlamalandCitizen> llamalandCitizensToCelebrate;

    public LlamalandCitizensToCelebrateFinder withMonarchistsFilePath(String monarchistsFilePath) {
        this.monarchistsFilePath = monarchistsFilePath;
        return this;
    }

    public LlamalandCitizensToCelebrateFinder withNonMonarchistsFilePath(String nonMonarchistsFilePath) {
        this.nonMonarchistsFilePath = nonMonarchistsFilePath;
        return this;
    }

    public LlamalandCitizensToCelebrateFinder findLlamalandCitizensToCelebrate() {

        List<LlamalandCitizen> llamalandCitizens = getLlamalandCitizens();
        llamalandCitizens.removeIf(new LlamalandCitizenDuplicateEmailPredicate(llamalandCitizens));

        llamalandCitizensToCelebrate = llamalandCitizens.stream()
                .filter(new LlamalandCitizenToCelebratePredicate(fromDate(), 5))
                .collect(toList());

        List<LlamalandCitizen> llamalandCitizensToCelebrateIn10Days = llamalandCitizens.stream()
                .filter(new LlamalandCitizenToCelebratePredicate(fromDate(), 10))
                .collect(toList());
        if (llamalandCitizensToCelebrateIn10Days.size() > 20) {
            llamalandCitizensToCelebrate.addAll(llamalandCitizensToCelebrateIn10Days);
        }

        return this;
    }

    public void prettyPrint() {
        System.out.println("Llamaland citizen to celebrate:");
        llamalandCitizensToCelebrate.forEach(llamalandCitizen -> System.out.printf("FirstName: %s, LastName: %s, DateOfBirth: %s, Email: %s\n",
                llamalandCitizen.getFirstName(),
                llamalandCitizen.getLastName(),
                llamalandCitizen.getDateOfBirth(),
                llamalandCitizen.getEmail()));
    }


    List<LlamalandCitizen> getLlamalandCitizens() {
        List<LlamalandCitizen> llamalandCitizens = new ArrayList<>();
        llamalandCitizens.addAll(new LlamalandMonarchistsFileReader().readFile(monarchistsFilePath));
        llamalandCitizens.addAll(new LlamalandNonMonarchistsFileReader().readFile(nonMonarchistsFilePath));
        return llamalandCitizens;
    }

    List<LlamalandCitizen> getLlamalandCitizensToCelebrate() {
        return llamalandCitizensToCelebrate;
    }

    LocalDate fromDate() {
        return now();
    }
}
