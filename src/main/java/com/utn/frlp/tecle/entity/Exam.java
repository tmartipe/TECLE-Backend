package com.utn.frlp.tecle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Entity(name = "EXAM")
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAM_GEN")
    @SequenceGenerator(name = "EXAM_GEN")
    private Long id;
    private LocalDateTime date;
    private String name;
    @OneToMany
    private List<Question> questionList;
    private Long time;
    public Exam(LocalDateTime date, String name, List<Question> questionList, Long time) {
        this.date = date;
        this.name = name;
        this.questionList = questionList;
        this.time = time;
    }
}
