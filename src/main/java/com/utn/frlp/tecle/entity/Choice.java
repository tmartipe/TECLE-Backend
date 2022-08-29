package com.utn.frlp.tecle.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CHOICE")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHOICE_GEN")
    @SequenceGenerator(name = "CHOICE_GEN")
    @EqualsAndHashCode.Include
    private Long id;
    private String text;
}
