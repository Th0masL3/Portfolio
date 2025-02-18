import React, { useEffect, useState, useContext } from "react";
import { AuthContext } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import "./AdminProjects.css";

const API_URL = "https://portfolio-iofk.onrender.com/api/v1/projects";

const AdminProjects: React.FC = () => {
    const [projects, setProjects] = useState<{ projectId: string, projectName: string, projectDescription: string, githubUrl: string }[]>([]);
    const [newProject, setNewProject] = useState({ projectName: "", projectDescription: "", githubUrl: "" });
    const auth = useContext(AuthContext);
    const navigate = useNavigate();

    // Redirect non-admin users
    useEffect(() => {
        if (!auth?.user || auth.user.role !== "admin") {
            navigate("/");
        } else {
            fetchProjects();
        }
    }, [auth, navigate]);

    // Fetch projects from API
    const fetchProjects = async () => {
        try {
            const response = await fetch(API_URL);
            if (!response.ok) throw new Error("Failed to fetch projects");
            const data = await response.json();
            setProjects(data);
        } catch (error) {
            console.error("Error fetching projects:", error);
        }
    };

    // Handle form input changes
    const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        setNewProject({ ...newProject, [e.target.name]: e.target.value });
    };

    // Add a new project
    const handleAddProject = async (e: React.FormEvent) => {
        e.preventDefault();
        if (!newProject.projectName.trim() || !newProject.githubUrl.trim()) return;

        try {
            const response = await fetch(API_URL, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(newProject),
            });

            if (response.ok) {
                const addedProject = await response.json();
                setProjects((prev) => [...prev, addedProject]);
                setNewProject({ projectName: "", projectDescription: "", githubUrl: "" }); // Reset form
            } else {
                console.error("Failed to add project");
            }
        } catch (error) {
            console.error("Error adding project:", error);
        }
    };

    // Delete a project
    const handleDeleteProject = async (projectId: string) => {
        if (!window.confirm("Are you sure you want to delete this project?")) return;

        try {
            const response = await fetch(`${API_URL}/${projectId}`, { method: "DELETE" });
            if (response.ok) {
                setProjects((prev) => prev.filter((project) => project.projectId !== projectId));
            } else {
                console.error("Failed to delete project");
            }
        } catch (error) {
            console.error("Error deleting project:", error);
        }
    };

    return (
        <div className="admin-projects-container">
            <h2>Manage Projects</h2>

            {/* Form to add a new project */}
            <form className="add-project-form" onSubmit={handleAddProject}>
                <input
                    type="text"
                    name="projectName"
                    value={newProject.projectName}
                    onChange={handleInputChange}
                    placeholder="Project Name"
                    required
                />
                <input
                    type="text"
                    name="projectDescription"
                    value={newProject.projectDescription}
                    onChange={handleInputChange}
                    placeholder="Project Description (optional)"
                />
                <input
                    type="url"
                    name="githubUrl"
                    value={newProject.githubUrl}
                    onChange={handleInputChange}
                    placeholder="GitHub URL"
                    required
                />
                <button type="submit">Add Project</button>
            </form>

            {/* Table displaying projects */}
            <table className="projects-table">
                <thead>
                <tr>
                    <th>Project Name</th>
                    <th>Description</th>
                    <th>GitHub</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {projects.map((project) => (
                    <tr key={project.projectId}>
                        <td>{project.projectName}</td>
                        <td>{project.projectDescription || "No description"}</td>
                        <td>
                            <a href={project.githubUrl} target="_blank" rel="noopener noreferrer">
                                View on GitHub
                            </a>
                        </td>
                        <td>
                            <button className="delete-btn" onClick={() => handleDeleteProject(project.projectId)}>❌</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default AdminProjects;
