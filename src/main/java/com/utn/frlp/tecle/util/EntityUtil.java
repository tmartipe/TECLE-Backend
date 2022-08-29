package com.utn.frlp.tecle.util;

import com.utn.frlp.tecle.dto.QuestionRequest;
import com.utn.frlp.tecle.dto.RegistrationRequest;
import com.utn.frlp.tecle.entity.Choice;
import com.utn.frlp.tecle.entity.Question;
import com.utn.frlp.tecle.entity.User;
import com.utn.frlp.tecle.enums.AppUserRole;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
public class EntityUtil {

    public static User buildUser(final RegistrationRequest registrationRequest){
        if(registrationRequest != null){
            return User.builder()
                    .academicUnit(registrationRequest.getAcademicUnit())
                    .age(registrationRequest.getAge())
                    .dni(registrationRequest.getDni())
                    .email(registrationRequest.getEmail())
                    .lastName(registrationRequest.getLastName())
                    .password(registrationRequest.getPassword())
                    .name(registrationRequest.getName())
                    .telephone(registrationRequest.getTelephone())
                    .appUserRole(AppUserRole.USER)
                    .enabled(false)
                    .build();
        }
        return User.builder().build();
    }

    public static Choice buildOption(final String option){
        if(option != null){
            return Choice.builder().text(option).build();
        }
        return Choice.builder().build();
    }

    public static Question buildQuestion(final QuestionRequest questionRequest){
        if(questionRequest != null){
            List<Choice> choices = new LinkedList<>();
            Arrays.stream(questionRequest.getChoices().split(";")).forEach(option -> {
                choices.add(buildOption(option));
            });

            return Question.builder()
                    .question(questionRequest.getQuestion())
                    .choices(choices)
                    .rightAnswer(questionRequest.getRightAnswer())
                    .build();

        }
        return Question.builder().build();
    }

}
