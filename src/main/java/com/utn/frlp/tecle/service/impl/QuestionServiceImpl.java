package com.utn.frlp.tecle.service.impl;

import com.utn.frlp.tecle.dto.QuestionDto;
import com.utn.frlp.tecle.dto.QuestionRequest;
import com.utn.frlp.tecle.entity.Question;
import com.utn.frlp.tecle.exception.BadRequestException;
import com.utn.frlp.tecle.repository.QuestionRepository;
import com.utn.frlp.tecle.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static com.utn.frlp.tecle.util.EntityUtil.buildQuestion;
import static java.util.Optional.ofNullable;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    @Transactional
    public QuestionDto createQuestion(QuestionRequest request) {
        ofNullable(request).orElseThrow(() -> new BadRequestException("Parameter is mandatory"));

        Question question = buildQuestion(request);

        questionRepository.save(question);

        return new QuestionDto(question);
    }

    @Override
    @Transactional
    public List<QuestionDto> createMultipleQuestions(List<QuestionRequest> request) {
        ofNullable(request).orElseThrow(() -> new BadRequestException("Parameter is mandatory"));

        List<Question> createdQuestions = new LinkedList<>();

        request.forEach(questionRequest -> {
           Question question = buildQuestion(questionRequest);
           createdQuestions.add(question);
        });

       questionRepository.saveAll(createdQuestions);

       return createdQuestions.stream().map(QuestionDto::new).collect(Collectors.toList());
    }

    @Override
    public List<QuestionDto> getAll() {
        return questionRepository.findAll().stream().map(QuestionDto::new).collect(Collectors.toList());
    }

    @Override
    public Question getById(Long id){
        return questionRepository.findById(id).orElseThrow(() -> new BadRequestException("La pregunta "+ id +"no ha sido encontrada"));
    }
}
