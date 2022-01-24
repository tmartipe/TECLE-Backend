package com.utn.frlp.tecle.controller;

import com.utn.frlp.tecle.dto.QuestionDto;
import com.utn.frlp.tecle.entity.Question;
import com.utn.frlp.tecle.service.QuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(value = "api/questions")
public class QuestionRestfullController {

    private final QuestionService questionService;

    @GetMapping("/")
    public ResponseEntity<Set<Question>> getAll() {
        return ResponseEntity.ok(questionService.getAll());
    }

    @PostMapping("/")
    public ResponseEntity<Question> createQuestion(final @RequestBody QuestionDto request){
        return ResponseEntity.ok(questionService.createQuestion(request));
    }

    @PostMapping("/multiple")
    public ResponseEntity<Set<Question>> createMultipleQuestions(final @RequestBody Set<QuestionDto> request){
        return ResponseEntity.ok(questionService.createMultipleQuestions(request));
    }
}
