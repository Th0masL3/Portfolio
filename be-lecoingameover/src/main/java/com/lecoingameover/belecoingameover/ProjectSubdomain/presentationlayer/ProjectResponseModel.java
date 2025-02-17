    package com.lecoingameover.belecoingameover.ProjectSubdomain.presentationlayer;

    import lombok.*;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class ProjectResponseModel {
        private String projectId;
        private String projectName;
        private String projectDescription;
        private String githubUrl;
    }