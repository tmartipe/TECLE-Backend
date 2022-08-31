package com.utn.frlp.tecle.service.impl;

import com.utn.frlp.tecle.entity.FinishedExam;
import com.utn.frlp.tecle.repository.FinishedExamRepository;
import com.utn.frlp.tecle.service.FinishedExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FinishedExamServiceImpl implements FinishedExamService {
    private FinishedExamRepository repository;


    @Override
    public FinishedExam save(FinishedExam finishedExam) {
        return repository.save(finishedExam);
    }
}
