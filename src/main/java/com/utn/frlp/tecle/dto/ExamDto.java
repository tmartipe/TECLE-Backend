package com.utn.frlp.tecle.dto;

import com.utn.frlp.tecle.entity.Exam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto {
    private Long id;
    private LocalDateTime date;
    private String name;
    private List<QuestionDto> questions;
    private Long time;

    public ExamDto(Exam exam){
        this.id = exam.getId();
        this.date = exam.getDate();
        this.name = exam.getName();
        this.questions = exam.getQuestionList().stream().map(QuestionDto::new).collect(Collectors.toList());
        this.time = exam.getTime();
    }
}
