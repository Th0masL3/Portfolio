import React, { useEffect, useState } from "react";
import { useLanguage } from "../LanguageContext";
import "./Projects.css";

const API_URL = "https://portfolio-iofk.onrender.com/api/v1/projects";

export default function Projects() {
    const { t } = useLanguage();
    const [projects, setProjects] = useState<{ title: string, description: string, github: string }[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        const fetchProjects = async () => {
            try {
                const response = await fetch(API_URL);
                if (!response.ok) throw new Error("Failed to fetch projects");
                const data = await response.json();
                setProjects(data.map((project: any) => ({
                    title: project.projectName,
                    description: project.projectDescription,
                    github: project.githubUrl
                })));
            } catch (error) {
                setError("Error loading projects");
                console.error(error);
            } finally {
                setLoading(false);
            }
        };

        fetchProjects();
    }, []);

    return (
        <section className="projects-container">
            <h2 className="projects-title">{t("projectsTitle")}</h2>
            {loading && <p>Loading...</p>}
            {error && <p className="error-message">{error}</p>}
            <div className="projects-grid">
                {projects.map((project, index) => (
                    <div key={index} className="project-card">
                        <h3 className="project-title">{project.title}</h3>
                        <p className="project-description">{project.description}</p>
                        <a href={project.github} target="_blank" rel="noopener noreferrer" className="project-link">
                            {t("githubLink")}
                        </a>
                    </div>
                ))}
            </div>
        </section>
    );
}
