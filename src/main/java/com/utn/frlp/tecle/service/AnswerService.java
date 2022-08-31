package com.utn.frlp.tecle.service;

import com.utn.frlp.tecle.dto.AnswerExamRequest;
import com.utn.frlp.tecle.dto.AnswerRequest;
import com.utn.frlp.tecle.dto.MessageResponse;

public interface AnswerService {

    MessageResponse registerExam(AnswerExamRequest request, String username);

}
