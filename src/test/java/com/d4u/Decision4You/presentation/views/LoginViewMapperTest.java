package com.d4u.Decision4You.presentation.views;

import com.d4u.Decision4You.domain.project.Project;
import com.d4u.Decision4You.domain.user.User;
import com.d4u.Decision4You.fixtures.ProjectFixture;
import com.d4u.Decision4You.fixtures.UserFixture;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class LoginViewMapperTest {

    LoginViewMapper mapper = LoginViewMapper.INSTANCE;

    @Test
    public void toLoginView_shouldMapParamsToLoginView() {
        // Given
        User user = UserFixture.createUser();
        List<User> otherUsers = Stream.generate(UserFixture::createUser).limit(3).toList();
        List<Project> createdProjects = Stream.generate(ProjectFixture::createProject).limit(3).toList();
        List<Project> invitedProjects = Stream.generate(ProjectFixture::createProject).limit(3).toList();

        // When
        Views.LoginView loginView = mapper.toLoginView(user, otherUsers, createdProjects, invitedProjects);

        // Then
        assertThat(loginView, notNullValue());
        assertThat(loginView.otherUsers(), notNullValue());
        assertThat(loginView.createdProjects(), notNullValue());
        assertThat(loginView.invitedProjects(), notNullValue());
    }
}
