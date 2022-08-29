package com.utn.frlp.tecle.entity;

import javax.persistence.*;

@Entity(name = "ANSWER")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANSWER_GEN")
    @SequenceGenerator(name = "ANSWER_GEN")
    private Long id;
    private String answer;
    @ManyToOne
    private Question question;
}
