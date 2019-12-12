package com.example.mco.application.facede;

import com.example.mco.application.entry_point.rest.dto.AnswerDto;
import com.example.mco.application.entry_point.rest.dto.QuestionnaireDTO;
import com.example.mco.application.mapper.AnswerMapper;
import com.example.mco.core.service.QuestionnaireReceivedBusinessCase;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireFacade {

    private final QuestionnaireReceivedBusinessCase userReceivedBC;
    private final AnswerMapper answerMapper;

    public QuestionnaireFacade(QuestionnaireReceivedBusinessCase userReceivedBC, AnswerMapper answerMapper) {
        this.userReceivedBC = userReceivedBC;
        this.answerMapper = answerMapper;
    }

    public void handleCreateAnswerFromRest(AnswerDto user) {
        userReceivedBC.handleCreateAnswer(answerMapper.dtoToModel(user));
    }

    public QuestionnaireDTO handleGetAllAnswers() {
        return new QuestionnaireDTO(answerMapper.modelsToDTOS(userReceivedBC.handleGetAllAnswers()));
    }

    public void handleUpdateAnswerFromRest(AnswerDto user) {
        userReceivedBC.handleUpdateAnswer(answerMapper.dtoToModel(user));
    }

    public void handleDeleteAnswerFromRest(AnswerDto user) {
        userReceivedBC.handleDeleteAnswer(answerMapper.dtoToModel(user));
    }
}