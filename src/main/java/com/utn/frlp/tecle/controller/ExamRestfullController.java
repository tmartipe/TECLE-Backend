package com.utn.frlp.tecle.controller;

import com.utn.frlp.tecle.dto.ExamDto;
import com.utn.frlp.tecle.dto.ExamRequest;
import com.utn.frlp.tecle.dto.MessageResponse;
import com.utn.frlp.tecle.service.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/exams")
public class ExamRestfullController {

    private ExamService examService;

    @PostMapping
    public ResponseEntity<MessageResponse> createExam(@RequestBody ExamRequest request){
        return ResponseEntity.ok(examService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ExamDto>> getAllExams(){
        return ResponseEntity.ok(examService.getAllExams());
    }
}
