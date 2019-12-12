package com.example.mco.application.entry_point.rest.controller;

import com.example.mco.application.entry_point.rest.dto.QuestionnaireDTO;
import com.example.mco.application.facede.QuestionnaireFacade;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class QuestionnaireControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private QuestionnaireController objectUnderTest;

    @Mock
    private QuestionnaireFacade questionnaireFacade;

    String validJson = "{\n" +
            "  \"mail\" : \"meto2te@gmail.com\",\n" +
            "  \"phoneNumber\" : \"+359883385878\",\n" +
            "  \"age\" : \"22\"\n" +
            "}";
    String invalidJson = "{\n" +
            "  \"mail\" : \"meto2te@gmail\",\n" +
            "  \"phoneNumber\" : \"+359883385878\",\n" +
            "  \"age\" : \"22\"\n" +
            "}";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(objectUnderTest).build();
    }

    @Test
    public void getAllAnswersTest() throws Exception {

        QuestionnaireDTO response = new QuestionnaireDTO();

        when(questionnaireFacade.handleGetAllAnswers()).thenReturn(response);
        mockMvc.perform(get("/v1/answers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createAnswerTest_When_request_is_emtpy_then_response_is_400() throws Exception {
        String json = "";
        mockMvc.perform(post("/v1/answers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createAnswerTest_When_request_is_invalid_then_response_is_400() throws Exception {
        mockMvc.perform(post("/v1/answers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(invalidJson))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createAnswerTest_When_correct_flight_received_then_response_is_200() throws Exception {

        mockMvc.perform(post("/v1/answers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(validJson))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void deleteAnswerTest_When_request_is_empty_then_response_is_400() throws Exception {
        String json = "";
        mockMvc.perform(delete("/v1/answers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteAnswerTest_When_request_is_invalid_then_response_is_400() throws Exception {
        mockMvc.perform(delete("/v1/answers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(invalidJson))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteAnswerTest_When_correct_flight_received_then_response_is_200() throws Exception {

               mockMvc.perform(delete("/v1/answers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(validJson))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


    @Test
    public void updateAnswerTest_When_request_is_emtpy_then_response_is_400() throws Exception {
        String json = "";
        mockMvc.perform(put("/v1/answers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(json))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateAnswerTest_When_request_is_invalid_then_response_is_400() throws Exception {
        mockMvc.perform(put("/v1/answers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(invalidJson))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateAnswerTest_When_correct_flight_received_then_response_is_200() throws Exception {

        mockMvc.perform(put("/v1/answers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(validJson))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
