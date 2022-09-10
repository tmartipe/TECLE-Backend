package com.utn.frlp.tecle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private Long time;
    public Exam(LocalDateTime date, String name, Long time) {
        this.date = date;
        this.name = name;
        this.time = time;
    }
}
