import React, { useState, useEffect, useCallback } from "react";
import { useAuth0 } from "@auth0/auth0-react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { ConsoleResponseModel } from "../Models/ConsoleResponseModel";
import "./Consoles.css";

interface UserResponseModel {
    userId: string;
    firstName: string;
    lastName: string;
    email: string;
    blocked: boolean;
    roles?: string[];
    permissions?: string[];
}

const Consoles: React.FC = () => {
    const [consoles, setConsoles] = useState<ConsoleResponseModel[]>([]);
    const [error, setError] = useState<string | null>(null);
    const [user, setUser] = useState<UserResponseModel | null>(null);
    const navigate = useNavigate();
    const { getAccessTokenSilently } = useAuth0();

    const fetchUserDetails = useCallback(async () => {
        try {
            const token = await getAccessTokenSilently();
            const response = await axios.get<UserResponseModel>("http://localhost:8080/api/v1/users/me", {
                headers: { Authorization: `Bearer ${token}` },
            });

            if (response.status === 200) {
                setUser(response.data);
            }
        } catch (err) {
            console.error("Error fetching user details:", err);
        }
    }, [getAccessTokenSilently]);

    const fetchAllConsoles = useCallback(async () => {
        try {
            const response = await axios.get("http://localhost:8080/api/v1/consoles");
            if (response.status === 200) {
                setConsoles(response.data);
            }
        } catch (err) {
            console.error("Error fetching consoles:", err);
            setError("Failed to fetch consoles.");
        }
    }, []);

    useEffect(() => {
        fetchUserDetails();
        fetchAllConsoles();
    }, [fetchUserDetails, fetchAllConsoles]);

    const addToCart = async (consoleId: string) => {
        try {
            const consoleRequest = consoles.find((c) => c.consoleId === consoleId);
            if (!consoleRequest) return;

            const response = await axios.post(`http://localhost:8080/api/v1/cart/console/${consoleId}`, consoleRequest);
            if (response.status === 201) {
                alert("Console added to cart!");
            }
        } catch (err) {
            console.error("Error adding to cart:", err);
            setError("Failed to add console to cart.");
        }
    };

    const handleCardClick = (consoleId: string) => {
        navigate(`/consoles/${consoleId}/products`);
    };

    const handleAddConsole = () => {
        navigate("/consoles/add");
    };

    const handleUpdateConsole = (event: React.MouseEvent, console: ConsoleResponseModel) => {
        event.stopPropagation();
        navigate("/consoles/edit", { state: { console } });
    };

    const handleDeleteConsole = async (event: React.MouseEvent, id: string) => {
        event.stopPropagation();
        if (window.confirm("Are you sure you want to delete this console?")) {
            try {
                const token = await getAccessTokenSilently();
                await axios.delete(`http://localhost:8080/api/v1/consoles/${id}`, {
                    headers: { Authorization: `Bearer ${token}` },
                });
                setConsoles((prevConsoles) => prevConsoles.filter((c) => c.consoleId !== id));
                alert("Console deleted successfully!");
            } catch (err) {
                console.error("Error deleting console:", err);
                setError("Failed to delete console.");
            }
        }
    };

    return (
        <div className="consoles-container">
            <h1 className="consoles-title">Consoles</h1>
            {error && <p className="consoles-error">{error}</p>}
            {user?.roles?.includes("Admin") && (
                <button className="add-console-button" onClick={handleAddConsole}>
                    Add Console
                </button>
            )}
            <div className="consoles-grid">
                {consoles.map((console) => (
                    <div key={console.consoleId} className="console-card" onClick={() => handleCardClick(console.consoleId)}>
                        <img src={console.image} alt={console.consoleName} className="console-card-image" />
                        <h3>{console.consoleName}</h3>
                        <p>Release Date: {console.releaseDate}</p>
                        <p>Price: ${console.price.toFixed(2)}</p>
                        <p>Stock: {console.quantityInStock}</p>
                        <p>Company: {console.company}</p>
                        <div className="console-card-actions">
                            {user?.roles?.includes("Customer") && (
                                <button onClick={() => addToCart(console.consoleId)}>Add to Cart</button>
                            )}
                            {user?.roles?.includes("Admin") && (
                                <>
                                    <button
                                        className="console-button"
                                        onClick={(event) => handleUpdateConsole(event, console)}
                                    >
                                        Update
                                    </button>
                                    <button
                                        className="console-button delete-button"
                                        onClick={(event) => handleDeleteConsole(event, console.consoleId)}
                                    >
                                        Delete
                                    </button>
                                </>
                            )}
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default Consoles;
