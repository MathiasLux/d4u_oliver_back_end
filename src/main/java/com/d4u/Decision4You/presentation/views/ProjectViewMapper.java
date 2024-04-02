package com.d4u.Decision4You.presentation.views;

import com.d4u.Decision4You.domain.project.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectViewMapper {

    ProjectViewMapper INSTANCE = Mappers.getMapper(ProjectViewMapper.class);

    Views.ProjectView toProjectView(Project projectView);
}
