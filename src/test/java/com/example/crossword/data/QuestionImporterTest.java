package com.example.crossword.data;

import com.example.crossword.data.model.WordEntity;
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

        assertEquals(171, wordRepository.count());
        WordEntity wordEntity = getWordEntity(1L);
        assertEquals("pozdrowienie", wordEntity.getWord());
        assertEquals("wypowiedź, która ma na celu przekazanie miłych słów komuś innemu, jest znakiem życzliwej pamięci", wordEntity.getQuestion());
        assertEquals("p", wordEntity.getFirstLetter());
        assertEquals(12, wordEntity.getTotalLetters());
    }

    private WordEntity getWordEntity(long id) {
        return wordRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not found word for id: " + id));
    }

}