package com.utn.frlp.tecle.controller;

import com.utn.frlp.tecle.dto.QuestionDto;
import com.utn.frlp.tecle.dto.QuestionRequest;
import com.utn.frlp.tecle.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(value = "api/questions")
public class QuestionRestfullController {

    private final QuestionService questionService;

    @GetMapping("/")
    public ResponseEntity<List<QuestionDto>> getAll() {
        return ResponseEntity.ok(questionService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<QuestionDto> createQuestion(final @RequestBody QuestionRequest request){
        return ResponseEntity.ok(questionService.createQuestion(request));
    }

    @PostMapping("/multiple")
    public ResponseEntity<List<QuestionDto>> createMultipleQuestions(final @RequestBody List<QuestionRequest> request){
        return ResponseEntity.ok(questionService.createMultipleQuestions(request));
    }
}
