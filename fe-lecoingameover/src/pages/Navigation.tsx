import React from "react";
import AuthButton from "./Auth/AuthButton";
import Profile from "./Auth/Profile";
import "./Navigation.css";

const Navigation = (): JSX.Element => {
    return (
        <nav className="navigation-bar">
            <div className="nav-container">
                {/* Left Icon (Menu) */}
                <div className="menu">
                    <a href="/">
                        <img src="./assets/images/icons-menu.png" alt="menuicon" className="icon" />
                    </a>
                </div>

                {/* Center Logo */}
                <div className="logo-container">
                    <a href="/">
                        <img src="./assets/images/CoinGameOverLogo.jpg" alt="Logo" className="logo" />
                    </a>
                </div>

                {/* Right Actions */}
                <div className="nav-actions">
                    <AuthButton />
                    <div className="profile-pic">
                        <Profile />
                    </div>
                    <div className="cart">
                        <a href="/cart">
                            <img src="./assets/images/icons-cart.png" alt="carticon" className="icon" />
                        </a>
                    </div>
                </div>
            </div>
        </nav>
    );
};

export default Navigation;
