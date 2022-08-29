package com.utn.frlp.tecle.entity;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "QUESTION")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Question implements Comparable<Question> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTION_GEN")
    @SequenceGenerator(name = "QUESTION_GEN")
    @EqualsAndHashCode.Include
    private Long id;
    private String rightAnswer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Choice> choices;
    private String question;

    @Override
    public int compareTo(@NotNull Question o) {
        return this.getId().compareTo(o.getId());
    }
}
