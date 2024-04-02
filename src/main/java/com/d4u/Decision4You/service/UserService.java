package com.d4u.Decision4You.service;


import com.d4u.Decision4You.domain.project.Project;
import com.d4u.Decision4You.domain.user.User;
import com.d4u.Decision4You.presentation.views.LoginViewMapper;
import com.d4u.Decision4You.presentation.views.Views;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final LoginViewMapper mapper = LoginViewMapper.INSTANCE;

    private final ProjectQueryService projectQueryService;
    private final UserQueryService userQueryService;


    // Login User
    // --------------------------------------------------------------------------------------------
    public Views.LoginView login(User authUser) {
        LOGGER.debug("User {} logins", authUser.getId());

        List<User> otherUsers = userQueryService.findAllExclude(authUser.getId());
        List<Project> createdProjects = projectQueryService.findAllMyCreated(authUser.getId());
        List<Project> invitedProjects = projectQueryService.findAllMyInvited(authUser.getId());

        LOGGER.debug("User {} logins with otherUsers: {}, createdProjects: {}, invitedProjects: {}",
                authUser.getId(), otherUsers, createdProjects, invitedProjects);

        var view = mapper.toLoginView(authUser, otherUsers, createdProjects, invitedProjects);
        LOGGER.debug("User {} logins successfully {}", authUser.getId(), view);
        return view;
    }
}
