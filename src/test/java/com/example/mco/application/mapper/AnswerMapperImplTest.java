package com.example.mco.application.mapper;

import com.example.mco.application.entry_point.rest.dto.AnswerDto;
import com.example.mco.core.model.Answer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class AnswerMapperImplTest {

    @InjectMocks
    private AnswerMapperImpl objectUnderTest;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void dtoToModelTest() {
        AnswerDto dto = new AnswerDto();
        dto.setMail("Stani@gmail.com");
        dto.setAge(22);
        dto.setPhoneNumber("+359888888888");
        Answer model = objectUnderTest.dtoToModel(dto);

        assertEquals(model.getAge(), dto.getAge());
        assertEquals(model.getMail(), dto.getMail());
        assertEquals(model.getPhoneNumber(), dto.getPhoneNumber());

    }

    @Test
    public void modelToDTOTest() {
        Answer model = new Answer();
        model.setMail("Stani@gmail.com");
        model.setAge(22);
        model.setPhoneNumber("+359888888888");
        AnswerDto dto = objectUnderTest.modelToDTO(model);

        assertEquals(dto.getAge(), model.getAge());
        assertEquals(dto.getMail(), model.getMail());
        assertEquals(dto.getPhoneNumber(), model.getPhoneNumber());
    }

}