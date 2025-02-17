package com.lecoingameover.belecoingameover.ProjectSubdomain.presentationlayer;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequestModel {
    private String projectName;
    private String projectDescription;
    private String githubUrl;
}
