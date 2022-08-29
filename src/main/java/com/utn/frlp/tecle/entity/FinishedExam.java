package com.utn.frlp.tecle.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "FINISHED_EXAM")
public class FinishedExam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FINISHED_EXAM_GEN")
    @SequenceGenerator(name = "FINISHED_EXAM_GEN")
    private Long id;
    @ManyToOne
    private Exam exam;
    @ManyToOne
    private User user;
    @OneToMany
    private List<Answer> answerList;
}
