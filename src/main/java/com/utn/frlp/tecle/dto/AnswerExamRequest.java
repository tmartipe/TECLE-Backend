package com.utn.frlp.tecle.dto;

import lombok.Data;

import java.util.List;
@Data
public class AnswerExamRequest {
    Long examId;
    List<AnswerRequest> answersList;
}
