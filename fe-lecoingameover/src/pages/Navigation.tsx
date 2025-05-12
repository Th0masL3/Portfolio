import React, { useContext, useState } from "react";
import { Link } from "react-router-dom";
import { AuthContext } from "../context/AuthContext";
import { AppRoutes } from "../shared/models/app.routes";
import { useLanguage } from "../LanguageContext";
import "./Navigation.css";

const Navigation: React.FC = () => {
    const auth = useContext(AuthContext);
    const { t, toggleLanguage, language } = useLanguage();
    const [menuOpen, setMenuOpen] = useState(false);

    const handleToggleMenu = () => setMenuOpen(prev => !prev);
    const closeMenu = () => setMenuOpen(false);

    return (
        <nav className="navbar">
            <h1 className="navbar-title">{t("portfolioTitle")}</h1>

            <div className="hamburger" onClick={handleToggleMenu}>
                ☰
            </div>

            <ul className={`navbar-links ${menuOpen ? "open" : ""}`}>
                <li><Link to={AppRoutes.Homepage} className="nav-link" onClick={closeMenu}>{t("home")}</Link></li>

                <li>
                    <Link
                        to={auth?.user?.role === "admin" ? AppRoutes.AdminAboutMe : AppRoutes.About}
                        className="nav-link"
                        onClick={closeMenu}
                    >
                        {t("about")}
                    </Link>
                </li>

                <li>
                    <Link
                        to={auth?.user?.role === "admin" ? AppRoutes.AdminProjects : AppRoutes.Projects}
                        className="nav-link"
                        onClick={closeMenu}
                    >
                        {t("projects")}
                    </Link>
                </li>

                <li><Link to={AppRoutes.PublicComment} className="nav-link" onClick={closeMenu}>{t("comments")}</Link></li>

                {auth?.user?.role === "admin" && (
                    <li>
                        <Link to={AppRoutes.Comments} className="nav-link" onClick={closeMenu}>{t("adminComments")}</Link>
                    </li>
                )}

                {/* Show auth controls in dropdown on mobile */}
                <li className="mobile-auth">
                    {auth?.user ? (
                        <>
                            <span className="mobile-user">{t("hello")}, {auth.user.username} ({auth.user.role})</span>
                            <button className="auth-btn logout-btn" onClick={() => { auth.logout(); closeMenu(); }}>
                                {t("logout")}
                            </button>
                        </>
                    ) : (
                        <Link to={AppRoutes.Login} onClick={closeMenu}>
                            <button className="auth-btn login-btn">{t("login")}</button>
                        </Link>
                    )}
                </li>

                <li className="mobile-lang">
                    <button className="lang-btn" onClick={() => { toggleLanguage(); closeMenu(); }}>
                        {language === "en" ? "Français" : "English"}
                    </button>
                </li>
            </ul>

            {/* Desktop only (kept separate from collapsed menu) */}
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

            <button className="lang-btn desktop-lang" onClick={toggleLanguage}>
                {language === "en" ? "Français" : "English"}
            </button>
        </nav>
    );
};

export default Navigation;
