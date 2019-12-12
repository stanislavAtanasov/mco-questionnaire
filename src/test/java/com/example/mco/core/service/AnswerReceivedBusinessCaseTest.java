package com.example.mco.core.service;

import com.example.mco.core.model.Answer;
import com.example.mco.core.repository.AnswerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class AnswerReceivedBusinessCaseTest {
    @Mock
    private AnswerRepository answerRepository;

    @InjectMocks
    private QuestionnaireReceivedBusinessCase objectUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void handleCreateAnswer() {
        Answer answer = new Answer();
        answer.setMail("mail");
        when(answerRepository.create(answer)).thenReturn(0);

    }

    //todo to add more test

}
