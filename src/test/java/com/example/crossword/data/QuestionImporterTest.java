package com.example.crossword.data;

import com.example.crossword.data.model.WordRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QuestionImporterTest {

    @Autowired
    private WordImporter wordImporter;

    @Autowired
    private WordRepository wordRepository;

    @Test
    void shouldImportData() {
        wordImporter.run();

        assertEquals(51, wordRepository.count());
    }
}