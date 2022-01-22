package com.utn.frlp.tecle.util;

import com.utn.frlp.tecle.dto.QuestionDto;
import com.utn.frlp.tecle.dto.UserDto;
import com.utn.frlp.tecle.entity.Option;
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

    public static Option buildOption(final String option){
        if(option != null){
            return Option.builder().text(option).build();
        }
        return Option.builder().build();
    }

    public static Question buildQuestion(final QuestionDto questionDto){
        if(questionDto != null){
            Set<Option> options = new HashSet<>();
            Arrays.stream(questionDto.getOptions().split(";")).forEach(option -> {
                options.add(buildOption(option));
            });

            return Question.builder()
                    .question(questionDto.getQuestion())
                    .options(options)
                    .rightAnswer(questionDto.getRightAnswer())
                    .build();

        }
        return Question.builder().build();
    }

}
