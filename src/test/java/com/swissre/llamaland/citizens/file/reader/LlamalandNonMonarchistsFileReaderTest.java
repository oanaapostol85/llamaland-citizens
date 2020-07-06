package com.swissre.llamaland.citizens.file.reader;

import com.swissre.llamaland.citizens.LlamalandCitizen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LlamalandNonMonarchistsFileReaderTest {

    private LlamalandNonMonarchistsFileReader fileReader;

    @BeforeEach
    public void setUp() {
        fileReader = new LlamalandNonMonarchistsFileReader();
    }

    @ParameterizedTest
    @ValueSource(strings = {"non_monarchists.csv", "non_monarchists_with_invalid_lines.csv"})
    public void givenValidInputFile_whenReadFile_thenLlamalandCitizenAreReturned(String fileName) {

        List<LlamalandCitizen> llamalandCitizens = fileReader.readFile(FilePath.getFilePathFromResources(fileName));

        assertFalse(llamalandCitizens.isEmpty());
        assertEquals(2, llamalandCitizens.size());

        Iterator<LlamalandCitizen> llamalandCitizenIterator = llamalandCitizens.iterator();
        assertEquals("betsy@heyitsme.com", llamalandCitizenIterator.next().getEmail());
        assertEquals("randomperson@llama.land", llamalandCitizenIterator.next().getEmail());
    }

    @Test
    public void givenFilePathDoesNotExist_whenReadFile_thenEmptyListIsReturned() {
        List<LlamalandCitizen> llamalandCitizens = fileReader.readFile("not_existing_file.csv");
        assertTrue(llamalandCitizens.isEmpty());
    }

}
