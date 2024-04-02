package com.d4u.Decision4You.presentation.views;

import com.d4u.Decision4You.domain.project.Project;
import com.d4u.Decision4You.fixtures.ProjectFixture;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ProjectViewMapperTest {

    ProjectViewMapper mapper = ProjectViewMapper.INSTANCE;

    @Test
    public void toProjectView_shouldMapProjectToProjectView() {
        // Given
        Project project = ProjectFixture.createProject();

        // When
        Views.ProjectView projectView = mapper.toProjectView(project);

        // Then
        assertThat(projectView, notNullValue());
        assertThat(projectView.id(), equalTo(project.getId()));
    }
}
