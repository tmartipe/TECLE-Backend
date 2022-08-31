package com.utn.frlp.tecle.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "ANSWER")
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANSWER_GEN")
    @SequenceGenerator(name = "ANSWER_GEN")
    private Long id;
    private String answer;
    @ManyToOne
    private Question question;

    public Answer(String answer, Question question){
        this.answer = answer;
        this.question = question;
    }
}
