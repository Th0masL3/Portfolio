package com.lecoingameover.belecoingameover.ProjectSubdomain.presentationlayer;

import com.lecoingameover.belecoingameover.ProjectSubdomain.businesslayer.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseModel>> getAllProjects() {
        List<ProjectResponseModel> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @PostMapping
    public ResponseEntity<ProjectResponseModel> addProject(@RequestBody ProjectRequestModel projectRequestModel) {
        ProjectResponseModel projectResponseModel = projectService.addProject(projectRequestModel);
        return ResponseEntity.ok(projectResponseModel);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<ProjectResponseModel> deleteProject(@PathVariable String projectId) {
        projectService.deleteProjectByProjectId(projectId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectResponseModel> updateProject(@RequestBody ProjectRequestModel projectRequestModel,
                                                              @PathVariable String projectId){
        ProjectResponseModel updatedProject = projectService.updateProject(projectRequestModel, projectId);
        return ResponseEntity.ok(updatedProject);
    }
}
