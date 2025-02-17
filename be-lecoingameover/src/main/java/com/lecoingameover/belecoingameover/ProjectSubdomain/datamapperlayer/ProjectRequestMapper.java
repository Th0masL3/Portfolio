package com.lecoingameover.belecoingameover.ProjectSubdomain.datamapperlayer;


import com.lecoingameover.belecoingameover.ProjectSubdomain.dataaccesslayer.Project;
import com.lecoingameover.belecoingameover.ProjectSubdomain.dataaccesslayer.ProjectIdentifier;
import com.lecoingameover.belecoingameover.ProjectSubdomain.presentationlayer.ProjectRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProjectRequestMapper {
    @Mappings({
            @Mapping(target = "projectId", ignore = true),
    })
    Project requestModelToEntity(ProjectRequestModel projectRequestModel, ProjectIdentifier projectIdentifier);
}