package com.utn.frlp.tecle.controller;

import com.utn.frlp.tecle.dto.CompleteExamRequest;
import com.utn.frlp.tecle.dto.ExamRequest;
import com.utn.frlp.tecle.dto.MessageResponse;
import com.utn.frlp.tecle.service.ExamService;
import com.utn.frlp.tecle.service.FinishedExamService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/complete-exam")
public class CompleteExamRestfulController {

    private final FinishedExamService service;

    @PostMapping
    public ResponseEntity<MessageResponse> completeExam(@RequestBody CompleteExamRequest request){
        return ResponseEntity.ok(service.completeExam(request));
    }


}
