package com.lecoingameover.belecoingameover.utils;

import com.lecoingameover.belecoingameover.AboutMeSubdomain.dataaccesslayer.AboutMe;
import com.lecoingameover.belecoingameover.AboutMeSubdomain.dataaccesslayer.AboutMeRepository;
import com.lecoingameover.belecoingameover.CommentSubdomain.dataaccesslayer.Comment;
import com.lecoingameover.belecoingameover.CommentSubdomain.dataaccesslayer.CommentRepository;
import com.lecoingameover.belecoingameover.ProjectSubdomain.dataaccesslayer.Project;
import com.lecoingameover.belecoingameover.ProjectSubdomain.dataaccesslayer.ProjectIdentifier;
import com.lecoingameover.belecoingameover.ProjectSubdomain.dataaccesslayer.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final CommentRepository commentRepository;
    private final AboutMeRepository aboutMeRepository;
    private final ProjectRepository projectRepository;

    public DatabaseInitializer(CommentRepository commentRepository, AboutMeRepository aboutMeRepository, ProjectRepository projectRepository) {
        this.commentRepository = commentRepository;
        this.aboutMeRepository = aboutMeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        initializeComments();
        initializeAboutMe();
        initializeProjects();
    }

    private void initializeComments() {
        commentRepository.deleteAll();

        List<Comment> sampleComments = List.of(
                new Comment(UUID.randomUUID().toString(), null, "1", "Alice", "Great website!", LocalDateTime.now(), false),
                new Comment(UUID.randomUUID().toString(), null, "2", "Bob", "Love the portfolio!", LocalDateTime.now().minusDays(1), false),
                new Comment(UUID.randomUUID().toString(), null, "3", "Charlie", "This is amazing!", LocalDateTime.now().minusHours(3), false)
        );

        commentRepository.saveAll(sampleComments);

        System.out.println("✅ Database initialized with test comments!");
    }

    private void initializeAboutMe() {
        if (!aboutMeRepository.existsById("about_me")) {
            AboutMe aboutMe = AboutMe.builder()
                    .infoId("about_me")
                    .skillsEn(Arrays.asList(
                            "Persevering",
                            "Respectful",
                            "Collaboration",
                            "Java",
                            "C#",
                            "HTML & CSS",
                            "JavaScript & React",
                            "SQL (MySQL, MongoDB, Oracle, MicrosoftSQL)",
                            "Git & GitHub",
                            "Project Management"
                    ))
                    .skillsFr(Arrays.asList(
                            "Persévérant",
                            "Respectueux",
                            "Collaboration",
                            "Java",
                            "C#",
                            "HTML & CSS",
                            "JavaScript & React",
                            "SQL (MySQL, MongoDB, Oracle, MicrosoftSQL)",
                            "Git & GitHub",
                            "Gestion de projet"
                    ))
                    .hobbiesEn(Arrays.asList(
                            "Gaming",
                            "Working Out",
                            "Volleyball",
                            "Ice Skating",
                            "Jogging"
                    ))
                    .hobbiesFr(Arrays.asList(
                            "Jeux vidéo",
                            "Musculation",
                            "Volleyball",
                            "Patinage sur glace",
                            "Course à pied"
                    ))
                    .build();

            aboutMeRepository.save(aboutMe);
            System.out.println("✅ Initialized 'About Me' document with default skills and hobbies (EN/FR) in MongoDB.");
        } else {
            System.out.println("✅ 'About Me' document already exists in MongoDB.");
        }
    }


    private void initializeProjects() {
        projectRepository.deleteAll();

        List<Project> projects = List.of(
                new Project(
                        UUID.randomUUID().toString(),
                        new ProjectIdentifier(),
                        "Le Coin Game Over",
                        "A website for a local game store featuring authentication, payment processing, and product browsing, built with Java and React.",
                        "https://github.com/AndrewBadIdea/LeCoinGameOver"
                ),
                new Project(
                        UUID.randomUUID().toString(),
                        new ProjectIdentifier(),
                        "Champlain Pet Clinic",
                        "A multi-service microservices-based application built using Spring Boot, Scrum, version control, and CI/CD.",
                        "https://github.com/cgerard321/champlain_petclinic"
                ),
                new Project(
                        UUID.randomUUID().toString(),
                        new ProjectIdentifier(),
                        "Pirate Ship Defense - Unity",
                        "A pirate-themed tower defense game inspired by Bloons TD, developed in Unity using C#.",
                        "https://github.com/Th0masL3/PirateShipDefense-UnityProject"
                ),
                new Project(
                        UUID.randomUUID().toString(),
                        new ProjectIdentifier(),
                        "Resume Builder",
                        "A .NET application that allows users to build and customize resumes, developed in C#.",
                        "https://github.com/Th0masL3/ResumeBuilder"
                )
        );

        projectRepository.saveAll(projects);

    }
}