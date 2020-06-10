package com.example.crossword.data.source;

import com.example.crossword.data.utils.QuestionParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class DictionaryReader {

    private final String dictionaryFilePath;

    public DictionaryReader(@Value("${crossword.dictionary.file-path:data/dictionary-small.xml}") String dictionaryFilePath) {
        this.dictionaryFilePath = dictionaryFilePath;
    }

    public List<Word> readWords() {
        log.info("read crossword data from: {}", dictionaryFilePath);

        try {
            List<Word> words = readDictionary()
                    .getWords()
                    .stream()
                    .filter(this::havingQuestion)
                    .filter(this::havingAtLeastTwoLetters)
                    .filter(this::havingOnlyLetters)
                    .sorted(Comparator.comparing(Word::getName))
                    .collect(Collectors.toList());
            log.info("read: {} words from: {}", words.size(), dictionaryFilePath);
            return words;
        } catch (JAXBException ex) {
            log.error("cannot parse dictionary xml", ex);
            return Collections.emptyList();
        }
    }

    private Dictionary readDictionary() throws JAXBException {
        return (Dictionary) JAXBContext.newInstance(Dictionary.class)
                .createUnmarshaller()
                .unmarshal(new File(dictionaryFilePath));
    }

    private boolean havingQuestion(Word word) {
        return QuestionParser.hasQuestion(word.getDesc());
    }

    private boolean havingAtLeastTwoLetters(Word word) {
        return word.getName().length() > 1;
    }

    private boolean havingOnlyLetters(Word word) {
        return StringUtils.isAlpha(word.getName());
    }
}
