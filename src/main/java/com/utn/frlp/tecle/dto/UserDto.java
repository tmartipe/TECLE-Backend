package com.utn.frlp.tecle.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {
    Long dni;
    String name;
    String lastName;
    String email;
    Long age;
    String academicUnit;
    String telephone;
}
