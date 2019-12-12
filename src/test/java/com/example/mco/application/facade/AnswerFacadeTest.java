package com.example.mco.application.facade;

import com.example.mco.application.facede.QuestionnaireFacade;
import com.example.mco.application.mapper.AnswerMapper;
import com.example.mco.core.service.QuestionnaireReceivedBusinessCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AnswerFacadeTest {
    @Mock
    private QuestionnaireReceivedBusinessCase questionnaireReceivedBC;
    @Mock
    private AnswerMapper answerMapper;

    @InjectMocks
    private QuestionnaireFacade objectUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void handleGetAllAnswersTest_WHEN_its_invoke_THEN_call_BC_AND_mapper() {
        objectUnderTest.handleGetAllAnswers();
        verify(questionnaireReceivedBC, times(1)).handleGetAllAnswers();
        verify(answerMapper, times(1)).modelsToDTOS(any());
    }
    //todo test for others methods
}
