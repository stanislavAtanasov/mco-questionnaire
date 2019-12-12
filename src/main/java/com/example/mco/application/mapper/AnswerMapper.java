package com.example.mco.application.mapper;

import com.example.mco.application.entry_point.rest.dto.AnswerDto;
import com.example.mco.core.model.Answer;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    public Answer dtoToModel(AnswerDto dto);

    public AnswerDto modelToDTO(Answer model);

    default List<AnswerDto> modelsToDTOS(Collection<Answer> models) {
        return Optional.ofNullable(models).map(Collection::stream).orElseGet(Stream::empty)
                .map(this::modelToDTO).collect(Collectors.toList());
    }
}
