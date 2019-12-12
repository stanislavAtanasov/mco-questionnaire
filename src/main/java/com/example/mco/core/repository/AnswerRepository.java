package com.example.mco.core.repository;

import com.example.mco.core.model.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository {

    public Optional<Answer> getByMail(String mail);

    public int create(Answer model);

    public int update(Answer model);

    public List<Answer> getAllAnswers();

    public int deleteByMail(String mail);
}
