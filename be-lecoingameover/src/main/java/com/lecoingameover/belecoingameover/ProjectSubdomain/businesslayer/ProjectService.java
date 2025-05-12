package com.lecoingameover.belecoingameover.ProjectSubdomain.businesslayer;

import com.lecoingameover.belecoingameover.ProjectSubdomain.presentationlayer.ProjectRequestModel;
import com.lecoingameover.belecoingameover.ProjectSubdomain.presentationlayer.ProjectResponseModel;

import java.util.List;

public interface ProjectService {
    public List<ProjectResponseModel> getAllProjects();
    public ProjectResponseModel addProject (ProjectRequestModel project);
    void deleteProjectByProjectId(String projectId);
    public ProjectResponseModel updateProject (ProjectRequestModel project, String projectId);

}
