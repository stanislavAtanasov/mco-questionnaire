package com.example.mco.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    private Integer id;
    private String mail;
    private String phoneNumber;
    private int age;
}

