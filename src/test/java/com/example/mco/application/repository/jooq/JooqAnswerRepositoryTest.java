package com.example.mco.application.repository.jooq;

import com.example.mco.core.model.Answer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class JooqAnswerRepositoryTest {

    public static final int ZERO_ROWS_ARE_AFFECTED = 0;

    @InjectMocks
    private JooqAnswerRepository objectUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createTest_WHEN_answer_is_null_THEN_return_is_0() {
        int actual = objectUnderTest.create(null);
        assertEquals(ZERO_ROWS_ARE_AFFECTED, actual);
    }

    @Test
    public void updateTestWHEN_answer_is_null_THEN_return_is_0() {
        int actual = objectUnderTest.update(null);
        assertEquals(ZERO_ROWS_ARE_AFFECTED, actual);
    }

    @Test
    public void updateTest_WHEN_answer_ID_is_null_THEN_return_is_0() {
        int actual = objectUnderTest.update(new Answer());
        assertEquals(ZERO_ROWS_ARE_AFFECTED, actual);
    }

    @Test
    public void updateTest_WHEN_answer_MAIL_is_null_THEN_return_is_0() {
        Answer answer = new Answer();
        answer.setId(23);
        int actual = objectUnderTest.update(new Answer());
        assertEquals(ZERO_ROWS_ARE_AFFECTED, actual);
    }

    @Test
    public void getByMailTest_WHEN_mail_is_null_THEN_return_empty() {
        Optional<Answer> actual = objectUnderTest.getByMail(null);
        assertFalse(actual.isPresent());
    }
}
