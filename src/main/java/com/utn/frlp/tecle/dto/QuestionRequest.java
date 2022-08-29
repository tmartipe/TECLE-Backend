package com.utn.frlp.tecle.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class QuestionRequest {

    String rightAnswer;
    String choices;
    String question;

}
