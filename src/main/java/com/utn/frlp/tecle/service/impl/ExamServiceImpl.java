package com.utn.frlp.tecle.service.impl;

import com.utn.frlp.tecle.dto.ExamDto;
import com.utn.frlp.tecle.dto.ExamRequest;
import com.utn.frlp.tecle.dto.MessageResponse;
import com.utn.frlp.tecle.entity.Exam;
import com.utn.frlp.tecle.exception.BadRequestException;
import com.utn.frlp.tecle.repository.ExamRepository;
import com.utn.frlp.tecle.service.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.utn.frlp.tecle.constants.ExamConstants.EXAM_SAVED;

@Service
@AllArgsConstructor
public class ExamServiceImpl implements ExamService {

    private ExamRepository repository;

    @Override
    public MessageResponse create(ExamRequest request) {
        Exam exam = new Exam(request.getDate(), request.getName(), request.getTime());
        repository.save(exam);
        return new MessageResponse(EXAM_SAVED);
    }

    @Override
    public List<ExamDto> getAllExams() {
        return repository.findAll().stream().map(ExamDto::new).collect(Collectors.toList());
    }

    @Override
    public Exam getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BadRequestException("El examen no fue encontrado. Revise el request."));
    }
}
