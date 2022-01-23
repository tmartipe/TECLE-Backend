package com.utn.frlp.tecle.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class QuestionDto {

    String rightAnswer;
    String choices;
    String question;

}
