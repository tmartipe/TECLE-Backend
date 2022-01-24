package com.utn.frlp.tecle.entity;

import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USER")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User implements Comparable<User>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private Long dni;
    private String name;
    private String lastName;
    private String email;
    private Long age;
    private String academicUnit;
    private String telephone;


    @Override
    public int compareTo(@NotNull User o) {
        return this.getLastName().compareTo(o.getLastName());
    }
}
