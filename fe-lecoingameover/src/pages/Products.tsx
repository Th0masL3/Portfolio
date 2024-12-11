import { useAuth0 } from "@auth0/auth0-react";
import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import "./Consoles.css";
import Navigation from "./Navigation";

interface ConsoleResponseModel {
    consoleId: string;
    consoleName: string;
    releaseDate: string;
    price: number;
    quantityInStock: number;
    company: string;
}

export default function Consoles(): JSX.Element {
    const [consoles, setConsoles] = useState<ConsoleResponseModel[]>([]);
    const [error, setError] = useState<string | null>(null);
    const navigate = useNavigate();
    const { user, isAuthenticated } = useAuth0();

    useEffect(() => {
        fetchAllConsoles();
    }, []);

    const fetchAllConsoles = async (): Promise<void> => {
        try {
            const response = await axios.get("http://localhost:8080/api/v1/consoles");
            if (response.status === 200) {
                setConsoles(response.data);
            }
        } catch (err) {
            console.error("Error fetching consoles:", err);
            setError("Failed to fetch consoles.");
        }
    };

    const handleEdit = (console: ConsoleResponseModel) => {
        navigate("/consoles/edit", { state: { console } });
    };

    const handleAddConsole = () => {
        navigate("/consoles/add");
    };

    const deleteConsole = async (id: string): Promise<void> => {
        try {
            const response = await axios.delete(`http://localhost:8080/api/v1/consoles/${id}`);
            if (response.status === 204) {
                setConsoles((prevConsoles) => prevConsoles.filter((console) => console.consoleId !== id));
                alert("Console deleted successfully!");
            }
        } catch (err) {
            console.error("Error deleting console:", err);
            setError("Failed to delete console.");
        }
    };

    const isAdmin = user && user["http://your-app.com/roles"]?.includes("ADMIN");

    return (
        <>
            <Navigation />
            <div className="console-container">
                <h1 className="console-title">Consoles</h1>
                {error && <p className="console-error">{error}</p>}
                {isAuthenticated && isAdmin && (
                    <div className="console-actions">
                        <button className="console-button" onClick={handleAddConsole}>
                            Add Console
                        </button>
                    </div>
                )}
                <table className="console-table">
                    <thead>
                    <tr>
                        <th>Console ID</th>
                        <th>Name</th>
                        <th>Release Date</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Company</th>
                        {isAuthenticated && isAdmin && (
                        <th>Actions</th>
                        )}
                    </tr>
                    </thead>
                    <tbody>
                    {consoles.map((console) => (
                        <tr key={console.consoleId}>
                            <td>{console.consoleId}</td>
                            <td>{console.consoleName}</td>
                            <td>{console.releaseDate}</td>
                            <td>${console.price.toFixed(2)}</td>
                            <td>{console.quantityInStock}</td>
                            <td>{console.company}</td>
                            <td>
                                {isAuthenticated && isAdmin && (
                                    <>
                                        <button className="console-button" onClick={() => handleEdit(console)}>
                                            Update
                                        </button>
                                        <button
                                            className="console-button delete-button"
                                            onClick={() => deleteConsole(console.consoleId)}
                                        >
                                            Delete
                                        </button>
                                    </>
                                )}
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </>
    );
}
