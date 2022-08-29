package com.utn.frlp.tecle.dto;

import com.utn.frlp.tecle.entity.Choice;
import com.utn.frlp.tecle.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    Long id;
    String question;
    String rightAnswer;
    List<String> choices;

    public QuestionDto(Question question) {
        this.id = question.getId();
        this.question = question.getQuestion();
        this.rightAnswer = question.getRightAnswer();
        this.choices = question.getChoices().stream().map(Choice::getText).collect(Collectors.toList());
    }
}
