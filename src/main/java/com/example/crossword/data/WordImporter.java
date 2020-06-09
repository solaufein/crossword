package com.example.crossword.data;

import com.example.crossword.data.model.WordEntity;
import com.example.crossword.data.source.DictionaryReader;
import com.example.crossword.data.source.Word;
import com.example.crossword.data.utils.QuestionParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class WordImporter implements CommandLineRunner {

    private final WordService wordService;
    private final DictionaryReader dictionaryReader;

    public WordImporter(WordService wordService, DictionaryReader dictionaryReader) {
        this.wordService = wordService;
        this.dictionaryReader = dictionaryReader;
    }

    @Override
    public void run(String... args) {
        if (wordService.isImportNeeded()) {
            List<Word> words = dictionaryReader.readWords();
            List<WordEntity> wordEntities = mapToEntitiesSorted(words);
            wordService.saveBatch(wordEntities);
        } else {
            log.info("skip importing data");
        }
    }

    private List<WordEntity> mapToEntitiesSorted(List<Word> words) {
        return words.stream()
                .map(this::mapToEntity)
                .sorted(Comparator.comparing(WordEntity::getTotalLetters).reversed())
                .collect(Collectors.toList());
    }

    private WordEntity mapToEntity(Word word) {
        String wordValue = word.getName();
        String question = getDesc(word);
        return new WordEntity(wordValue, question, wordValue.substring(0, 1), wordValue.length());
    }

    private String getDesc(Word word) {
        return QuestionParser.getQuestion(word.getDesc());
    }

}
