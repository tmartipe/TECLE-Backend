package com.utn.frlp.tecle.service;

import com.utn.frlp.tecle.dto.ExamDto;
import com.utn.frlp.tecle.dto.ExamRequest;
import com.utn.frlp.tecle.dto.MessageResponse;
import com.utn.frlp.tecle.entity.Exam;

import java.util.List;
import java.util.Set;

public interface ExamService {

    MessageResponse create(ExamRequest request);

    List<ExamDto> getAllExams();
    Exam getById(Long id);

}
