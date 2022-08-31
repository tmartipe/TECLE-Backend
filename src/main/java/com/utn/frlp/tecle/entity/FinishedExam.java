package com.utn.frlp.tecle.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "FINISHED_EXAM")
@NoArgsConstructor
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

    public FinishedExam(Exam exam, User user, List<Answer> answerList) {
        this.exam = exam;
        this.user = user;
        this.answerList = answerList;
    }
}
