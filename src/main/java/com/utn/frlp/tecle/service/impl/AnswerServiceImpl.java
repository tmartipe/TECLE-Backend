package com.utn.frlp.tecle.service.impl;

import com.utn.frlp.tecle.dto.AnswerExamRequest;
import com.utn.frlp.tecle.dto.AnswerRequest;
import com.utn.frlp.tecle.dto.MessageResponse;
import com.utn.frlp.tecle.entity.*;
import com.utn.frlp.tecle.service.AnswerService;
import com.utn.frlp.tecle.service.ExamService;
import com.utn.frlp.tecle.service.QuestionService;
import com.utn.frlp.tecle.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import static com.utn.frlp.tecle.constants.ExamConstants.FINISHED_EXAM_SAVED;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {
    private UserService userService;
    private QuestionService questionService;
    private ExamService examService;
    @Override
    public MessageResponse registerExam(AnswerExamRequest request, String username) {
        User user = userService.getUserByEmail(username);
        List<Answer> answers = new LinkedList<Answer>();
        Exam exam = examService.getById(request.getExamId());
        for(AnswerRequest answer : request.getAnswersList()){
            Question question = questionService.getById(answer.getQuestionId());
            answers.add(new Answer(answer.getAnswer(), question));
        }
        FinishedExam finishedExam = new FinishedExam(exam, user, answers);
        return new MessageResponse(FINISHED_EXAM_SAVED);
    }
}
