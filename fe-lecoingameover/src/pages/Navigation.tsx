import React from "react";
import { Link } from "react-router-dom";
import AuthButton from "./Auth/AuthButton";
import Profile from "./Auth/Profile";
import "./Navigation.css";

const Navigation = (): JSX.Element => {
    return (
        <nav className="navigation-bar">
            <div className="logo-container">
                {/* Add logo image */}
                <img src="./assets/images/CoinGameOverLogo.jpg" alt="Logo" className="logo" />
            </div>
            <div className="nav-links">
                <Link to="/consoles">Consoles</Link>
            </div>
            <div className="nav-actions">
                <AuthButton />
                <div className="profile-pic">
                    <Profile />
                </div>

            </div>
        </nav>
    );
};

export default Navigation;
