package com.utn.frlp.tecle.service.impl;

import com.utn.frlp.tecle.dto.QuestionDto;
import com.utn.frlp.tecle.entity.Question;
import com.utn.frlp.tecle.exception.BadRequestException;
import com.utn.frlp.tecle.repository.QuestionRepository;
import com.utn.frlp.tecle.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.utn.frlp.tecle.util.EntityUtil.buildQuestion;
import static java.util.Optional.ofNullable;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Question createQuestion(QuestionDto request) {
        ofNullable(request).orElseThrow(() -> new BadRequestException("Parameter is mandatory"));

        Question question = buildQuestion(request);

        questionRepository.save(question);

        return question;
    }

    @Override
    public Set<Question> createMultipleQuestions(Set<QuestionDto> request) {
        ofNullable(request).orElseThrow(() -> new BadRequestException("Parameter is mandatory"));

        Set<Question> createdQuestions = new HashSet<>();

       request.forEach(questionDto -> {
           Question question = buildQuestion(questionDto);
           createdQuestions.add(question);
       });

       questionRepository.saveAll(createdQuestions);

       return createdQuestions;
    }
}
