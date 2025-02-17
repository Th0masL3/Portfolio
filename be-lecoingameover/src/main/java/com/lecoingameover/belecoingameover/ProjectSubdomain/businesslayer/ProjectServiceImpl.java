package com.lecoingameover.belecoingameover.ProjectSubdomain.businesslayer;

import com.lecoingameover.belecoingameover.ProjectSubdomain.dataaccesslayer.Project;
import com.lecoingameover.belecoingameover.ProjectSubdomain.dataaccesslayer.ProjectIdentifier;
import com.lecoingameover.belecoingameover.ProjectSubdomain.dataaccesslayer.ProjectRepository;
import com.lecoingameover.belecoingameover.ProjectSubdomain.datamapperlayer.ProjectRequestMapper;
import com.lecoingameover.belecoingameover.ProjectSubdomain.datamapperlayer.ProjectResponseMapper;
import com.lecoingameover.belecoingameover.ProjectSubdomain.presentationlayer.ProjectRequestModel;
import com.lecoingameover.belecoingameover.ProjectSubdomain.presentationlayer.ProjectResponseModel;
import com.lecoingameover.belecoingameover.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {


    private final ProjectRepository projectRepository;
    private final ProjectResponseMapper projectResponseMapper;
    private final ProjectRequestMapper projectRequestMapper;


    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectResponseMapper projectResponseMapper, ProjectRequestMapper projectRequestMapper) {
        this.projectRepository = projectRepository;
        this.projectResponseMapper = projectResponseMapper;
        this.projectRequestMapper = projectRequestMapper;
    }


    @Override
    public List<ProjectResponseModel> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projectResponseMapper.entityToResponseModelList(projects);
    }

    @Override
    public ProjectResponseModel addProject(ProjectRequestModel projectRequestModel) {
        Project project = projectRequestMapper.requestModelToEntity(projectRequestModel, new ProjectIdentifier());
        Project savedProject = projectRepository.save(project);
        return projectResponseMapper.entityToResponseModel(savedProject);
    }

    @Override
    public void deleteProjectByProjectId(String projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new NotFoundException("Project not found with id: " + projectId));
        projectRepository.delete(project);
    }
}
