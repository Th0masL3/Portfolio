import React, { useEffect, useState, useContext } from "react";
import { AuthContext } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import "./AdminAboutMe.css";

const API_URL = "http://localhost:8080/api/v1/aboutme";

const AdminAboutMe: React.FC = () => {
    const [skills, setSkills] = useState<string[]>([]);
    const [hobbies, setHobbies] = useState<string[]>([]);
    const [newSkill, setNewSkill] = useState("");
    const [newHobby, setNewHobby] = useState("");
    const [language, setLanguage] = useState("en"); // Default to English
    const auth = useContext(AuthContext);
    const navigate = useNavigate();

    useEffect(() => {
        if (!auth?.user || auth.user.role !== "admin") {
            navigate("/");
        } else {
            fetchSkills();
            fetchHobbies();
        }
    }, [auth, navigate, language]); // ✅ Fetches new data when language changes

    const fetchSkills = async () => {
        try {
            const response = await fetch(`${API_URL}/skills?lang=${language}`);
            if (!response.ok) throw new Error("Failed to fetch skills");
            const data = await response.json();
            setSkills(data.skills || []);
        } catch (error) {
            console.error("Error fetching skills:", error);
        }
    };

    const fetchHobbies = async () => {
        try {
            const response = await fetch(`${API_URL}/hobbies?lang=${language}`);
            if (!response.ok) throw new Error("Failed to fetch hobbies");
            const data = await response.json();
            setHobbies(data.hobbies || []);
        } catch (error) {
            console.error("Error fetching hobbies:", error);
        }
    };

    const handleAddSkill = async () => {
        if (!newSkill.trim()) return;
        try {
            const response = await fetch(`${API_URL}/skills`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ skill: newSkill, lang: language }), // ✅ Pass selected language
            });
            if (response.ok) {
                setSkills((prev) => [...prev, newSkill]);
                setNewSkill("");
            } else {
                console.error("Failed to add skill");
            }
        } catch (error) {
            console.error("Error adding skill:", error);
        }
    };

    const handleDeleteSkill = async (skill: string) => {
        if (!window.confirm(`Are you sure you want to delete "${skill}"?`)) return;
        try {
            const response = await fetch(`${API_URL}/skills/${skill}?lang=${language}`, { method: "DELETE" });
            if (response.ok) {
                setSkills((prev) => prev.filter((s) => s !== skill));
            } else {
                console.error("Failed to delete skill");
            }
        } catch (error) {
            console.error("Error deleting skill:", error);
        }
    };

    const handleAddHobby = async () => {
        if (!newHobby.trim()) return;
        try {
            const response = await fetch(`${API_URL}/hobbies`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ hobby: newHobby, lang: language }),
            });
            if (response.ok) {
                setHobbies((prev) => [...prev, newHobby]);
                setNewHobby("");
            } else {
                console.error("Failed to add hobby");
            }
        } catch (error) {
            console.error("Error adding hobby:", error);
        }
    };

    const handleDeleteHobby = async (hobby: string) => {
        if (!window.confirm(`Are you sure you want to delete "${hobby}"?`)) return;
        try {
            const response = await fetch(`${API_URL}/hobbies/${hobby}?lang=${language}`, { method: "DELETE" });
            if (response.ok) {
                setHobbies((prev) => prev.filter((h) => h !== hobby));
            } else {
                console.error("Failed to delete hobby");
            }
        } catch (error) {
            console.error("Error deleting hobby:", error);
        }
    };

    return (
        <div className="admin-about-container">
            <h2>Manage About Me</h2>

            {/* Language Selection Dropdown */}
            <label>
                Select Language:
                <select value={language} onChange={(e) => setLanguage(e.target.value)}>
                    <option value="en">English</option>
                    <option value="fr">Français</option>
                </select>
            </label>

            {/* Skills Section */}
            <div className="management-section">
                <h3>Skills</h3>
                <input
                    type="text"
                    value={newSkill}
                    onChange={(e) => setNewSkill(e.target.value)}
                    placeholder="Enter new skill"
                />
                <button onClick={handleAddSkill}>Add Skill</button>
                <table className="skills-table">
                    <thead>
                    <tr>
                        <th>Skill</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    {skills.map((skill) => (
                        <tr key={skill}>
                            <td>{skill}</td>
                            <td>
                                <button className="delete-btn" onClick={() => handleDeleteSkill(skill)}>❌</button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

            {/* Hobbies Section */}
            <div className="management-section">
                <h3>Hobbies</h3>
                <input
                    type="text"
                    value={newHobby}
                    onChange={(e) => setNewHobby(e.target.value)}
                    placeholder="Enter new hobby"
                />
                <button onClick={handleAddHobby}>Add Hobby</button>
                <table className="hobbies-table">
                    <thead>
                    <tr>
                        <th>Hobby</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    {hobbies.map((hobby) => (
                        <tr key={hobby}>
                            <td>{hobby}</td>
                            <td>
                                <button className="delete-btn" onClick={() => handleDeleteHobby(hobby)}>❌</button>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default AdminAboutMe;
