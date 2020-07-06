package com.swissre.llamaland.citizens.file.reader;

import com.swissre.llamaland.citizens.LlamalandCitizen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import static java.time.Month.*;
import static org.junit.jupiter.api.Assertions.*;

public class LlamalandMonarchistsFileReaderTest {

    private LlamalandMonarchistsFileReader fileReader;

    @BeforeEach
    public void setUp() {
        fileReader = new LlamalandMonarchistsFileReader();
    }

    @ParameterizedTest
    @ValueSource(strings = {"monarchists.csv", "monarchists_with_invalid_lines.csv"})
    public void givenValidInputFile_whenReadFile_thenLlamalandCitizenAreReturned(String fileName) {

        List<LlamalandCitizen> llamalandCitizens = fileReader.readFile(FilePath.getFilePathFromResources(fileName));

        assertFalse(llamalandCitizens.isEmpty());
        assertEquals(3, llamalandCitizens.size());

        Iterator<LlamalandCitizen> llamalandCitizenIterator = llamalandCitizens.iterator();

        assertLlamalandCitizen("Bobby", "Brown", LocalDate.of(1959, NOVEMBER, 10), "bobby.brown@ilovellamaland.com", llamalandCitizenIterator.next());
        assertLlamalandCitizen("Betsy", "O'Rourke", LocalDate.of(1900, FEBRUARY, 28), "betsy@heyitsme.com", llamalandCitizenIterator.next());
        assertLlamalandCitizen("Alfredo", "Von Tappo", LocalDate.of(1920, JANUARY, 1), "alfie@vontappo.llama.land", llamalandCitizenIterator.next());
    }

    @Test
    public void givenFilePathDoesNotExist_whenReadFile_thenEmptyListIsReturned() {
        List<LlamalandCitizen> llamalandCitizens = fileReader.readFile("not_existing_file.csv");
        assertTrue(llamalandCitizens.isEmpty());
    }

    private void assertLlamalandCitizen(String firstName, String lastName, LocalDate dateOfBirth, String email, LlamalandCitizen llamalandCitizen) {
        assertEquals(firstName, llamalandCitizen.getFirstName());
        assertEquals(lastName, llamalandCitizen.getLastName());
        assertEquals(dateOfBirth, llamalandCitizen.getDateOfBirth());
        assertEquals(email, llamalandCitizen.getEmail());
    }
}
