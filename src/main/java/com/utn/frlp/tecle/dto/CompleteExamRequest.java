package com.utn.frlp.tecle.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompleteExamRequest {
    Long id;
    List<AnswerRequest> answers;
}
