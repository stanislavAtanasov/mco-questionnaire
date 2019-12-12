package com.example.mco.application.entry_point.rest.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@JsonPropertyOrder(value = {"mail", "phoneNumber", "age"})
public class AnswerDto {
    public static final String REGEX_FOR_MAIL = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}";
    @NotNull
    @Pattern(regexp = REGEX_FOR_MAIL, message = "Please, use valid mail")
    private String mail;
    public static final String REGEX_FOR_BG_NUMER = "\\+359\\d{9}";
    @Pattern(regexp = REGEX_FOR_BG_NUMER, message = "Please, use Bulgarian phone number. example +359888888888")
    @NotNull
    private String phoneNumber;

    @NotNull
    @Min(0)
    @Max(200)
    private int age;

}
