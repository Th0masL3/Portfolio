import React, { useContext } from "react";
import { Link } from "react-router-dom";
import { AuthContext } from "../context/AuthContext";
import { AppRoutes } from "../shared/models/app.routes";
import { useLanguage } from "../LanguageContext";
import "./Navigation.css";

const Navigation: React.FC = () => {
    const auth = useContext(AuthContext);
    const { t, toggleLanguage, language } = useLanguage();

    return (
        <nav className="navbar">
            <h1 className="navbar-title">{t("portfolioTitle")}</h1>

            <ul className="navbar-links">
                <li><Link to={AppRoutes.Homepage} className="nav-link">{t("home")}</Link></li>

                {/* Admins see Admin About Me, others see regular About Me */}
                <li>
                    <Link to={auth?.user?.role === "admin" ? AppRoutes.AdminAboutMe : AppRoutes.About}
                          className="nav-link">
                        {t("about")}
                    </Link>
                </li>

                <li>
                    <Link to={auth?.user?.role === "admin" ? AppRoutes.AdminProjects : AppRoutes.Projects}
                          className="nav-link">
                        {t("projects")}
                    </Link>
                </li>

                <li><Link to={AppRoutes.PublicComment} className="nav-link">{t("comments")}</Link></li>

                {/* Admin-only section */}
                {auth?.user?.role === "admin" && (
                    <li><Link to={AppRoutes.Comments} className="nav-link">{t("adminComments")}</Link></li>
                )}
            </ul>

            <div className="auth-container">
                {auth?.user ? (
                    <div className="user-info">
                        <span>{t("hello")}, {auth.user.username} ({auth.user.role})</span>
                        <button className="auth-btn logout-btn" onClick={auth.logout}>{t("logout")}</button>
                    </div>
                ) : (
                    <Link to={AppRoutes.Login}>
                        <button className="auth-btn login-btn">{t("login")}</button>
                    </Link>
                )}
            </div>

            <button className="lang-btn" onClick={toggleLanguage}>
                {language === "en" ? "Français" : "English"}
            </button>
        </nav>
    );
};

export default Navigation;
