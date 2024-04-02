package com.d4u.Decision4You.presentation.views;

import com.d4u.Decision4You.domain.project.Project;
import com.d4u.Decision4You.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {UserViewMapper.class, ProjectViewMapper.class})
public interface LoginViewMapper {

    LoginViewMapper INSTANCE = Mappers.getMapper(LoginViewMapper.class);

    Views.LoginView toLoginView(User authUser, List<User> otherUsers, List<Project> createdProjects, List<Project> invitedProjects);
}
