package com.utn.frlp.tecle.controller;

import com.utn.frlp.tecle.dto.AnswerExamRequest;
import com.utn.frlp.tecle.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/answers")
public class AnswerRestfulController {

    private AnswerService answerService;

    @PostMapping
    public ResponseEntity<?> answerExam(@AuthenticationPrincipal String username, @RequestBody AnswerExamRequest request){
        return ResponseEntity.ok(answerService.registerExam(request, username));
    }

}
