package com.utn.frlp.tecle.service;

import com.utn.frlp.tecle.dto.QuestionDto;
import com.utn.frlp.tecle.dto.QuestionRequest;
import com.utn.frlp.tecle.entity.Question;

import java.util.List;
import java.util.Set;

public interface QuestionService {

    QuestionDto createQuestion(QuestionRequest request);

    List<QuestionDto> createMultipleQuestions(List<QuestionRequest> request);

    List<QuestionDto> getAll();
    Question getById(Long id);
}
