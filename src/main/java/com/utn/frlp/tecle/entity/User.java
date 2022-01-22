package com.utn.frlp.tecle.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "USER")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

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


}
