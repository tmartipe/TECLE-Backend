package com.utn.frlp.tecle.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest {
    Long dni;
    String name;
    String lastName;
    String email;
    Long age;
    String academicUnit;
    String telephone;
    String password;
}
