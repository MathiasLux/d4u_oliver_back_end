package com.d4u.Decision4You.presentation.views;

import com.d4u.Decision4You.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserViewMapper {

    UserViewMapper INSTANCE = Mappers.getMapper(UserViewMapper.class);

    @Mapping(source = "profile.firstName", target = "firstName")
    @Mapping(source = "profile.lastName", target = "lastName")
    Views.UserView toUserView(User user);
}
