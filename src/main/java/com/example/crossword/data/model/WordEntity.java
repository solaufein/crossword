package com.example.crossword.data.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "word", schema = "crossword")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class WordEntity {

    @EqualsAndHashCode.Include
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "word_id_seq")
    @SequenceGenerator(schema = "crossword", name = "word_id_seq", allocationSize = 1)
    private Long id;

    @Column
    private String word;

    @Column(length = 500)
    private String question;

    @Column(name = "first_letter", length = 1)
    private String firstLetter;

    @Column(name = "total_letters")
    private int totalLetters;

    public WordEntity(String word, String question, String firstLetter, int totalLetters) {
        this.word = word;
        this.question = question;
        this.firstLetter = firstLetter;
        this.totalLetters = totalLetters;
    }
}
