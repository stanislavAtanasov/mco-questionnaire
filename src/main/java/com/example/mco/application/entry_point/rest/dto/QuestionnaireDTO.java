package com.example.mco.application.entry_point.rest.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value = {"answers"})
public class QuestionnaireDTO {
    List<AnswerDto> answers;
}
