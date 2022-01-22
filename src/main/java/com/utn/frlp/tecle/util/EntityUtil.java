package com.utn.frlp.tecle.util;

import com.utn.frlp.tecle.dto.UserRequest;
import com.utn.frlp.tecle.entity.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EntityUtil {

    public static User buildUser(final UserRequest userRequest){
        if(userRequest != null){
            return User.builder()
                    .academicUnit(userRequest.getAcademicUnit())
                    .age(userRequest.getAge())
                    .dni(userRequest.getDni())
                    .email(userRequest.getEmail())
                    .lastName(userRequest.getLastName())
                    .name(userRequest.getName())
                    .telephone(userRequest.getTelephone())
                    .build();
        }
        return User.builder().build();
    }

}
