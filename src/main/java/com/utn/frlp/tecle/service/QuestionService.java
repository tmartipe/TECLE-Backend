package com.utn.frlp.tecle.service;

import com.utn.frlp.tecle.dto.QuestionDto;
import com.utn.frlp.tecle.entity.Question;

import java.util.Set;

public interface QuestionService {

    Question createQuestion(QuestionDto request);

    Set<Question> createMultipleQuestions(Set<QuestionDto> request);

}
