package com.example.mco.core.repository;

import com.example.mco.BaseIntegrationTest;
import com.example.mco.core.model.Answer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:db/insertData.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:db/deleteTableData.sql")
})
public class AnswerRepositoryIT extends BaseIntegrationTest {

    @Autowired
    private AnswerRepository objUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getByMailTest_When_there_isnt_user_with_that_mail_THEN_return_empty_optional() {
        Optional<Answer> findObject = objUnderTest.getByMail("Many@gmail.com");
        assertFalse(findObject.isPresent());
        assertEquals(Optional.empty(), findObject);
    }

    @Test
    public void getByMailTest_When_there_is_user_with_that_mail_THEN_return_the_user() {
        Optional<Answer> findObject = objUnderTest.getByMail("in@gmail.com");
        Answer expected = new Answer(1, "in@gmail.com", "+359888888888", 17);
        assertEquals(expected, findObject.get());
    }

    @Test
    public void createTest_when_create_and_get_user_THEN_return_the_created_user() {
        Answer answer = new Answer(null, "in2@gmail.com", "+359888888888", 17);
        int cretedRows = objUnderTest.create(answer);
        assertEquals(1, cretedRows);
        Optional<Answer> findObject = objUnderTest.getByMail("in2@gmail.com");
        answer.setId(findObject.get().getId());
        assertEquals(answer, findObject.get());
    }

    @Test
    public void updateTest_WHEN_update_and_get_user_THEN_return_the_updated_user() {
        Answer answer = objUnderTest.getByMail("in@gmail.com").get();
        int updatedRows = objUnderTest.update(answer);
        assertEquals(1, updatedRows);
        Answer actual = objUnderTest.getByMail("in@gmail.com").get();
        assertEquals(answer, actual);
    }

    @Test
    public void updateTest_WHEN_try_to_update_inexistant_user_THEN_return_0() {
        Answer answer = new Answer(889987, "out@gmail.com", "+359888888888", 17);
        int updatedRows = objUnderTest.update(answer);
        assertEquals(0, updatedRows);
    }

    //todo to add tests for delete
}