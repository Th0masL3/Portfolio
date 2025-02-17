import React, { useEffect, useState } from "react";
import { TranslationKeys, useLanguage } from "../LanguageContext";
import { translations } from "../LanguageContext";
import "./AboutMe.css";

export default function About() {
    const { t, language } = useLanguage(); // Get current language from context

    // State to store skills and hobbies
    const [skills, setSkills] = useState<string[]>([]);
    const [hobbies, setHobbies] = useState<string[]>([]);

    // Fetch data whenever the language changes
    useEffect(() => {
        fetchSkills();
        fetchHobbies();
    }, [language]);

    const fetchSkills = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/v1/aboutme/skills?lang=${language}`);
            if (!response.ok) throw new Error("Failed to fetch skills");
            const data = await response.json();
            setSkills(data.skills || []); // Ensure it doesn't break if response is empty
        } catch (error) {
            console.error("Error fetching skills:", error);
        }
    };

    const fetchHobbies = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/v1/aboutme/hobbies?lang=${language}`);
            if (!response.ok) throw new Error("Failed to fetch hobbies");
            const data = await response.json();
            setHobbies(data.hobbies || []); // Ensure it doesn't break if response is empty
        } catch (error) {
            console.error("Error fetching hobbies:", error);
        }
    };

    // Translate function to fall back to the original text if no translation exists
    const translate = (key: string): string => {
        const normalizedKey = key.toLowerCase().replace(/\s+/g, "");
        return translations[language]?.[normalizedKey as keyof TranslationKeys] || key;
    };

    return (
        <section className="about">
            <h2>{t("aboutTitle")}</h2>
            <p>{t("aboutDescription")}</p>

            {/* Skills & Hobbies Section */}
            <div className="skills-hobbies-container">
                {/* Skills Section */}
                <div className="skills">
                    <h3>{t("skills")}</h3>
                    <ul>
                        {skills.length > 0 ? (
                            skills.map((skill, index) => (
                                <li key={index}><strong>{translate(skill)}</strong></li>
                            ))
                        ) : (
                            <li>Loading...</li>
                        )}
                    </ul>
                </div>

                {/* Hobbies Section */}
                <div className="hobbies">
                    <h3>{t("hobbies")}</h3>
                    <ul>
                        {hobbies.length > 0 ? (
                            hobbies.map((hobby, index) => (
                                <li key={index}><strong>{translate(hobby)}</strong></li>
                            ))
                        ) : (
                            <li>Loading...</li>
                        )}
                    </ul>
                </div>
            </div>
            <div className="cv-download">
                <h3>{t("cvPrompt")}</h3>
                <p>English Version:
                    <a href="/File/CV_EnglishThomas.pdf" download>
                        <button className="download-btn">{t("downloadCV")} EN</button>
                    </a>
                </p>
                <p>Version Française:
                    <a href="/File/CVFrench.pdf" download>
                        <button className="download-btn">{t("downloadCV")} FR</button>
                    </a>
                </p>
            </div>
</section>
)
    ;
}
