package com.example.mco.application.mapper;

import com.example.mco.application.entry_point.rest.dto.AnswerDto;
import com.example.mco.core.model.Answer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-12T18:37:05+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public Answer dtoToModel(AnswerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Answer answer = new Answer();

        answer.setMail( dto.getMail() );
        answer.setPhoneNumber( dto.getPhoneNumber() );
        answer.setAge( dto.getAge() );

        return answer;
    }

    @Override
    public AnswerDto modelToDTO(Answer model) {
        if ( model == null ) {
            return null;
        }

        AnswerDto answerDto = new AnswerDto();

        answerDto.setMail( model.getMail() );
        answerDto.setPhoneNumber( model.getPhoneNumber() );
        answerDto.setAge( model.getAge() );

        return answerDto;
    }
}
