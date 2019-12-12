package com.example.mco.core.service;

import com.example.mco.core.model.Answer;
import com.example.mco.core.repository.AnswerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class QuestionnaireReceivedBusinessCase {
    private final AnswerRepository answerRepository;

    @Autowired
    public QuestionnaireReceivedBusinessCase(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void handleCreateAnswer(Answer answer) {
        if (answerRepository.getByMail(answer.getMail()).isPresent()) {
            log.debug("Skipping handleCreateAnswer. Reason: answer with such mail is in db.");
            return;
        }
        answerRepository.create(answer);
    }

    public void handleUpdateAnswer(Answer answer) {
        Optional<Answer> dbAnswer = answerRepository.getByMail(answer.getMail());
        if (!dbAnswer.isPresent()) {
            log.debug("Skipping handleUpdateAnswer. Reason: answer is not in db.");
            return;
        }
        answer.setId(dbAnswer.get().getId());
        answerRepository.update(answer);
    }


    public List<Answer> handleGetAllAnswers() {
        return answerRepository.getAllAnswers();
    }

    public void handleDeleteAnswer(Answer answer) {
        if (!answerRepository.getByMail(answer.getMail()).isPresent()) {
            log.debug("Skipping handleDeleteAnswer. Reason: answer is not in db.");
            return;
        }
        answerRepository.deleteByMail(answer.getMail());
    }


}
