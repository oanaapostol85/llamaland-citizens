package com.swissre.llamaland.citizens;

import java.time.LocalDate;
import java.util.function.Predicate;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class LlamalandCitizenToCelebrate implements Predicate<LlamalandCitizen> {

    private static final int YEARS_TO_CELEBRATE = 100;

    private final LocalDate fromDate;

    private final int weekdaysNotice;

    public LlamalandCitizenToCelebrate(LocalDate fromDate, int weekdaysNotice) {
        this.fromDate = fromDate;
        this.weekdaysNotice = weekdaysNotice;
    }

    @Override
    public boolean test(LlamalandCitizen llamalandCitizen) {
        if (llamalandCitizen.getDateOfBirth() == null) {
            return false;
        }

        LocalDate dateOfBirthToCelebrate = llamalandCitizen.getDateOfBirth().plusYears(YEARS_TO_CELEBRATE);
        if (SATURDAY == dateOfBirthToCelebrate.getDayOfWeek()) {
            dateOfBirthToCelebrate = dateOfBirthToCelebrate.minusDays(1);
        }
        if (SUNDAY == dateOfBirthToCelebrate.getDayOfWeek()) {
            dateOfBirthToCelebrate = dateOfBirthToCelebrate.minusDays(2);
        }

        return plusWeekday(fromDate, weekdaysNotice).isEqual(dateOfBirthToCelebrate);
    }

    private LocalDate plusWeekday(LocalDate date, int weekdays) {

        if (SATURDAY == date.getDayOfWeek() || SUNDAY == date.getDayOfWeek()) {
            return plusWeekday(date.plusDays(1), weekdays);
        }

        if (weekdays == 0) {
            return date;
        }

        return plusWeekday(date.plusDays(1), --weekdays);
    }
}
