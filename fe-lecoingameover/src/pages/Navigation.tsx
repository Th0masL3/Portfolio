import React, { useEffect, useState } from "react";
import AuthButton from "./Auth/AuthButton";
import Profile from "./Auth/Profile";
import { useAuth0 } from "@auth0/auth0-react";
import axios from "axios";
import { Link } from "react-router-dom";
import "./Navigation.css";

interface UserResponseModel {
    userId: string;
    firstName: string;
    lastName: string;
    email: string;
    blocked: boolean;
    roles?: string[];
    permissions?: string[];
}

const Navigation = (): JSX.Element => {
    const { getAccessTokenSilently } = useAuth0();
    const [user, setUser] = useState<UserResponseModel | null>(null);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        fetchUserDetails();
    }, []);

    const fetchUserDetails = async (): Promise<void> => {
        try {
            const token = await getAccessTokenSilently();

            // Fetch current user details from the /me endpoint
            const response = await axios.get<UserResponseModel>(
                "http://localhost:8080/api/v1/users/me",
                {
                    headers: {
                        Authorization: `Bearer ${token}`,
                    },
                }
            );

            if (response.status === 200) {
                setUser(response.data); // Set user state
            }
        } catch (err) {
            console.error("Error fetching user details:", err);
            setError("Failed to fetch user details.");
        }
    };

    const canAccessCart = user?.roles?.some((role) => ["Customer", "Admin"].includes(role));

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
                    {canAccessCart && (
                        <div className="cart">
                            {/* Replace anchor tag with Link to Cart page */}
                            <Link to="/cart">
                                <img src="./assets/images/icons-cart.png" alt="carticon" className="icon" />
                            </Link>
                        </div>
                    )}
                </div>
            </div>
        </nav>
    );
};

export default Navigation;
