package com.utn.frlp.tecle.util;

import com.utn.frlp.tecle.dto.QuestionDto;
import com.utn.frlp.tecle.dto.UserDto;
import com.utn.frlp.tecle.entity.Choice;
import com.utn.frlp.tecle.entity.Question;
import com.utn.frlp.tecle.entity.User;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
public class EntityUtil {

    public static User buildUser(final UserDto userDto){
        if(userDto != null){
            return User.builder()
                    .academicUnit(userDto.getAcademicUnit())
                    .age(userDto.getAge())
                    .dni(userDto.getDni())
                    .email(userDto.getEmail())
                    .lastName(userDto.getLastName())
                    .name(userDto.getName())
                    .telephone(userDto.getTelephone())
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

    public static Question buildQuestion(final QuestionDto questionDto){
        if(questionDto != null){
            Set<Choice> choices = new HashSet<>();
            Arrays.stream(questionDto.getChoices().split(";")).forEach(option -> {
                choices.add(buildOption(option));
            });

            return Question.builder()
                    .question(questionDto.getQuestion())
                    .choices(choices)
                    .rightAnswer(questionDto.getRightAnswer())
                    .build();

        }
        return Question.builder().build();
    }

}
