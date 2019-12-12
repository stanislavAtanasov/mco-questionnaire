package com.example.mco.application.entry_point.rest.dto;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuestionnaireDTOTest {

    @Test
    public void bgPhoneNumberRegexTest() {
        String bgNumber = "+359888888888";
        String bgNumber2 = "+359888888488";
        String nonbgNumber2 = "+352888888488";
        String nonbgNumber = "+88488";

        assertTrue(bgNumber.matches(AnswerDto.REGEX_FOR_BG_NUMER));
        assertTrue(bgNumber2.matches(AnswerDto.REGEX_FOR_BG_NUMER));
        assertFalse(nonbgNumber2.matches(AnswerDto.REGEX_FOR_BG_NUMER));
        assertFalse(nonbgNumber.matches(AnswerDto.REGEX_FOR_BG_NUMER));
    }

    @Test
    public void mailRegexTest() {
        String validMail = "meto@abv.bg";
        String validMail2 = "djony@gmail.com";
        String nonValidMail = "meto.abv.bg";
        String nonValidMail2 = "meto@abvbg";

        assertTrue(validMail.matches(AnswerDto.REGEX_FOR_MAIL));
        assertTrue(validMail2.matches(AnswerDto.REGEX_FOR_MAIL));
        assertFalse(nonValidMail.matches(AnswerDto.REGEX_FOR_MAIL));
        assertFalse(nonValidMail2.matches(AnswerDto.REGEX_FOR_MAIL));
    }


}
