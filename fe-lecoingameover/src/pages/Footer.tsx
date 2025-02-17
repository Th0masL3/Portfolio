import React from "react";
import { useLanguage } from "../LanguageContext";
import "./Footer.css";

export default function Footer() {
    const { t } = useLanguage();

    return (
        <footer className="footer">
            <div className="footer-container">
                <div className="footer-section">
                    <h2>{t("footerTitle")}</h2>
                    <p>{t("footerDescription")}</p>
                </div>

                <div className="footer-section">
                    <h3>{t("contact")}</h3>
                    <ul className="footer-contact">
                        <li>
                            <a href="mailto:thomas.lemay@outlook.com" className="footer-link">
                                <img src="/assets/images/emailimg.png" alt="Email Icon" className="footer-icon"/>
                            </a>
                        </li>
                        <li>
                            <a href="https://www.linkedin.com/in/thomas-lemay-50568932a/" target="_blank" rel="noopener noreferrer" className="footer-link">
                                <img src="/assets/images/linkedInIcon.png" alt="LinkedIn Icon" className="footer-icon" />
                            </a>
                        </li>
                        <li>
                            <a href="https://github.com/Th0masL3" target="_blank" rel="noopener noreferrer" className="footer-link">
                                <img src="/assets/images/githubicon.png" alt="GitHub Icon" className="footer-icon" />
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <div className="footer-bottom">
                <p>{t("allRightsReserved").replace("{year}", new Date().getFullYear().toString())}</p>
            </div>
        </footer>
    );
}
