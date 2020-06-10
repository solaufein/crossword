package com.example.crossword.data;

import com.example.crossword.data.model.WordEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class QuestionImporterTest {

    @Autowired
    private WordImporter wordImporter;

    @Qualifier("inMemoryWordService")
    @Autowired
    private WordService wordService;

    @Test
    void shouldImportData() {
        wordImporter.run();

        assertEquals(171, wordService.size());
        WordEntity wordEntity = getWordEntity("pozdrowienie");
        assertEquals("pozdrowienie", wordEntity.getWord());
        assertEquals("wypowiedź, która ma na celu przekazanie miłych słów komuś innemu, jest znakiem życzliwej pamięci", wordEntity.getQuestion());
        assertEquals("p", wordEntity.getFirstLetter());
        assertEquals(12, wordEntity.getTotalLetters());
    }

    private WordEntity getWordEntity(String word) {
        return wordService.findByWord(word).orElseThrow(() -> new IllegalArgumentException("Not found word: " + word));
    }

}