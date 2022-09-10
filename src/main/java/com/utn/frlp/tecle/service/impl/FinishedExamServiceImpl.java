package com.utn.frlp.tecle.service.impl;

import com.utn.frlp.tecle.dto.CompleteExamRequest;
import com.utn.frlp.tecle.dto.MessageResponse;
import com.utn.frlp.tecle.entity.Exam;
import com.utn.frlp.tecle.service.ExamService;
import com.utn.frlp.tecle.service.FinishedExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FinishedExamServiceImpl implements FinishedExamService {

    private ExamService examService;
    @Override
    public MessageResponse completeExam(CompleteExamRequest request) {
        Exam exam = examService.getById(request.getId());
        return null;
    }
}
