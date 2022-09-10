package com.utn.frlp.tecle.dto;

import com.utn.frlp.tecle.entity.Exam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamDto {
    private Long id;
    private LocalDateTime date;
    private String name;
    private Long time;

    public ExamDto(Exam exam){
        this.id = exam.getId();
        this.date = exam.getDate();
        this.name = exam.getName();
        this.time = exam.getTime();
    }
}
