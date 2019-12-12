package com.example.mco.application.entry_point.rest.controller;

import com.example.mco.application.entry_point.rest.dto.AnswerDto;
import com.example.mco.application.entry_point.rest.dto.QuestionnaireDTO;
import com.example.mco.application.facede.QuestionnaireFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1/answers")
public class QuestionnaireController {
    private final QuestionnaireFacade questionnaireFacade;

    public QuestionnaireController(QuestionnaireFacade questionnaireFacade) {
        this.questionnaireFacade = questionnaireFacade;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void createAnswer(@RequestBody @Valid AnswerDto request) {
        log.info("Create answer from rest with mail: {}", request.getMail());
        questionnaireFacade.handleCreateAnswerFromRest(request);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public QuestionnaireDTO getAllAnswers() {
        log.info("get all answers from rest ");
        return questionnaireFacade.handleGetAllAnswers();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateAnswer(@RequestBody @Valid AnswerDto request) {
        log.info("Update answer from rest with mail: {}", request.getMail());
        questionnaireFacade.handleUpdateAnswerFromRest(request);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteAnswer(@RequestBody @Valid AnswerDto request) {
        log.info("Delete answer from rest with mail: {}", request.getMail());
        questionnaireFacade.handleDeleteAnswerFromRest(request);
    }
}
