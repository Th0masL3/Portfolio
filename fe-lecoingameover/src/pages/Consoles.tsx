import { useAuth0 } from "@auth0/auth0-react";
import "./Consoles.css";
import Navigation from "./Navigation";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { ConsoleResponseModel } from "../Models/ConsoleResponseModel";

export default function Consoles(): JSX.Element {
    const [consoles, setConsoles] = useState<ConsoleResponseModel[]>([]);
    const [error, setError] = useState<string | null>(null);
    const navigate = useNavigate();
    const { getAccessTokenSilently } = useAuth0();

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

    const handleRowClick = (consoleId: string) => {
        navigate(`/consoles/${consoleId}/products`);
    };

    const handleEdit = (event: React.MouseEvent, console: ConsoleResponseModel) => {
        event.stopPropagation(); // Prevent row click event
        navigate("/consoles/edit", { state: { console } });
    };

    const handleAddConsole = () => {
        navigate("/consoles/add");
    };

    const deleteConsole = async (event: React.MouseEvent, id: string): Promise<void> => {
        event.stopPropagation(); // Prevent row click event

        const userConfirmed = window.confirm(
            "Are you sure you want to delete this console?"
        );

        if (!userConfirmed) {
            return; // Exit if user cancels the deletion
        }

        try {
            const token = await getAccessTokenSilently();

            const response = await axios.delete(`http://localhost:8080/api/v1/consoles/${id}`, {
                headers: {
                    Authorization: `Bearer ${token}`,
                },
            });

            if (response.status === 204) {
                setConsoles((prevConsoles) => prevConsoles.filter((console) => console.consoleId !== id));
                alert("Console deleted successfully!");
            }
        } catch (err: any) {
            console.error("Error deleting console:", err);
            const errorMessage = err.response?.data?.message || err.message || "An unknown error occurred.";
            setError(`Failed to delete console: ${errorMessage}`);
        }
    };

    return (
        <>
            <Navigation />
            <div className="console-container">
                <h1 className="console-title">Consoles</h1>
                {error && <p className="console-error">{error}</p>}

                <div className="console-actions">
                    <button className="console-button" onClick={handleAddConsole}>
                        Add Console
                    </button>
                </div>

                <table className="console-table">
                    <thead>
                    <tr>
                        <th>Console ID</th>
                        <th>Name</th>
                        <th>Release Date</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Company</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {consoles.map((console) => (
                        <tr
                            key={console.consoleId}
                            onClick={() => handleRowClick(console.consoleId)}
                            style={{ cursor: "pointer" }}
                        >
                            <td>{console.consoleId}</td>
                            <td>{console.consoleName}</td>
                            <td>{console.releaseDate}</td>
                            <td>${console.price.toFixed(2)}</td>
                            <td>{console.quantityInStock}</td>
                            <td>{console.company}</td>
                            <td>
                                <>
                                    <button
                                        className="console-button"
                                        onClick={(e) => handleEdit(e, console)}
                                    >
                                        Update
                                    </button>
                                    <button
                                        className="console-button delete-button"
                                        onClick={(e) => deleteConsole(e, console.consoleId)}
                                    >
                                        Delete
                                    </button>
                                </>
                            </td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>
        </>
    );
}
