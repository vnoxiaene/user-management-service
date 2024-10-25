package com.devandersen.usermanagementservice.mappers;

import com.devandersen.usermanagementservice.dto.UserRequestVO;
import com.devandersen.usermanagementservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

    User userRequestVOtoUser(UserRequestVO userRequestVO);
}
