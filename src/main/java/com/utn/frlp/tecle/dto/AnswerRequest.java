package com.utn.frlp.tecle.dto;

import lombok.Data;

@Data
public class AnswerRequest {
    Long questionId;
    String answer;
}
