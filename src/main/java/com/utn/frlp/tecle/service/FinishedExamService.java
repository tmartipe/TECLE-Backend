package com.utn.frlp.tecle.service;

import com.utn.frlp.tecle.dto.CompleteExamRequest;
import com.utn.frlp.tecle.dto.MessageResponse;
import org.springframework.stereotype.Service;


public interface FinishedExamService {

    MessageResponse completeExam(CompleteExamRequest request);

}
