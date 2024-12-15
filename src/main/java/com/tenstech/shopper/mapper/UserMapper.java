package com.tenstech.shopper.mapper;

import com.tenstech.shopper.model.User;
import com.tenstech.shopper.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDTO(User user);
    User userDTOToUser(UserDto userDTO);
}