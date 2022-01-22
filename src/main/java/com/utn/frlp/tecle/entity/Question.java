package com.utn.frlp.tecle.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "QUESTION")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String rightAnswer;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<Option> options;

    private String question;
}
