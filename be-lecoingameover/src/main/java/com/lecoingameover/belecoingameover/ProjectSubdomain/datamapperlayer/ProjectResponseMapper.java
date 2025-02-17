package com.lecoingameover.belecoingameover.ProjectSubdomain.datamapperlayer;

import com.lecoingameover.belecoingameover.ProjectSubdomain.dataaccesslayer.Project;
import com.lecoingameover.belecoingameover.ProjectSubdomain.presentationlayer.ProjectResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectResponseMapper {
    @Mapping(source = "projectId", target = "projectId")
    ProjectResponseModel entityToResponseModel(Project project);

    List<ProjectResponseModel> entityToResponseModelList(List<Project> projectList);

}
