import React from "react";
import { useLanguage } from "../LanguageContext";
import "./Home.css";

export default function Home() {
    const { t } = useLanguage();

    return (
        <div className="home-content">
            <div className="profile-container">
                <img src="/assets/images/thomasportfoliopicture.PNG" alt="Thomas Lemay" className="profile-picture"/>
            </div>

            <h1>{t("welcomeTitle")}</h1>
            <p>{t("welcomeMessage")}</p>

            <div className="home-sections">
                <ul>
                    <li>{t("projectsShowcase")}</li>
                    <li>{t("skillsSection")}</li>
                    <li>{t("hobbiesSection")}</li>
                    <li>{t("commentsSection")}</li>
                </ul>
            </div>

            <p><strong>{t("cvNote")}</strong></p>
        </div>
    );
}
