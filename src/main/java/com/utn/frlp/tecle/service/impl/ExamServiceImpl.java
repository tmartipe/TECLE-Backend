package com.utn.frlp.tecle.service.impl;

import com.utn.frlp.tecle.dto.ExamDto;
import com.utn.frlp.tecle.dto.ExamRequest;
import com.utn.frlp.tecle.dto.MessageResponse;
import com.utn.frlp.tecle.entity.Exam;
import com.utn.frlp.tecle.entity.Question;
import com.utn.frlp.tecle.exception.BadRequestException;
import com.utn.frlp.tecle.repository.ExamRepository;
import com.utn.frlp.tecle.service.ExamService;
import com.utn.frlp.tecle.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.utn.frlp.tecle.constants.ExamConstants.EXAM_NOT_FOUND;
import static com.utn.frlp.tecle.constants.ExamConstants.EXAM_SAVED;

@Service
@AllArgsConstructor
public class ExamServiceImpl implements ExamService {

    private ExamRepository repository;
    private QuestionService questionService;

    @Override
    public MessageResponse create(ExamRequest request) {
        List<Question> questions = new LinkedList<>();
        for(Long id : request.getQuestionIds()){
            questions.add(questionService.getById(id));
        }
        Exam exam = new Exam(request.getDate(), request.getName(), questions, request.getTime());
        repository.save(exam);
        return new MessageResponse(EXAM_SAVED);
    }

    @Override
    public List<ExamDto> getAllExams() {
        return repository.findAll().stream().map(ExamDto::new).collect(Collectors.toList());
    }

    @Override
    public Exam getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BadRequestException(EXAM_NOT_FOUND));
    }
}
