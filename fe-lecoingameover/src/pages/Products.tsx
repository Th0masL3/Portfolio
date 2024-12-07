import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Consoles.css';

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

    useEffect(() => {
        fetchAllConsoles();
    }, []);

    const fetchAllConsoles = async (): Promise<void> => {
        try {
            const response = await axios.get('http://localhost:8080/api/v1/consoles');
            if (response.status === 200) {
                setConsoles(response.data);
            }
        } catch (err) {
            console.error('Error fetching consoles:', err);
            setError('Failed to fetch consoles.');
        }
    };

    const handleEdit = (console: ConsoleResponseModel) => {
        navigate('/consoles/edit', { state: { console } });
    };

    return (
        <div className="console-container">
            <h1 className="console-title">Consoles</h1>
            {error && <p className="console-error">{error}</p>}
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
                    <tr key={console.consoleId}>
                        <td>{console.consoleId}</td>
                        <td>{console.consoleName}</td>
                        <td>{console.releaseDate}</td>
                        <td>${console.price.toFixed(2)}</td>
                        <td>{console.quantityInStock}</td>
                        <td>{console.company}</td>
                        <td>
                            <button
                                className="console-button"
                                onClick={() => handleEdit(console)}
                            >
                                Update
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}
