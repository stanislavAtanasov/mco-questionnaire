package com.example.mco.application.mapper;

import com.example.mco.application.entry_point.rest.dto.UserResponseDTO;
import com.example.mco.core.model.UserResponse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-12-12T17:02:42+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
@Component
public class UserResponseMapperImpl implements UserResponseMapper {

    @Override
    public UserResponseDTO userResponseToUserResponseDTO(UserResponse model) {
        if ( model == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setStatus( model.getStatus() );

        return userResponseDTO;
    }
}
