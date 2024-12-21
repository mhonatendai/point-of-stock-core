package com.tenstech.pointofstock.mapper;

import com.tenstech.pointofstock.model.User;
import com.tenstech.pointofstock.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    UserDto userToUserDTO(User user);
    User userDTOToUser(UserDto userDTO);
}