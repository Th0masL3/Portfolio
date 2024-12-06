import { useState, useEffect } from 'react';
import axios from 'axios';

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

    useEffect(() => {
        fetchAllConsoles();
    }, []);

    return (
        <div style={{ padding: '20px' }}>
            <h1>Consoles</h1>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            {consoles.length > 0 ? (
                <table style={{ width: '100%', borderCollapse: 'collapse', marginTop: '20px' }}>
                    <thead>
                    <tr>
                        <th style={{ border: '1px solid #ddd', padding: '8px' }}>Console ID</th>
                        <th style={{ border: '1px solid #ddd', padding: '8px' }}>Name</th>
                        <th style={{ border: '1px solid #ddd', padding: '8px' }}>Release Date</th>
                        <th style={{ border: '1px solid #ddd', padding: '8px' }}>Price</th>
                        <th style={{ border: '1px solid #ddd', padding: '8px' }}>Quantity</th>
                        <th style={{ border: '1px solid #ddd', padding: '8px' }}>Company</th>
                    </tr>
                    </thead>
                    <tbody>
                    {consoles.map(console => (
                        <tr key={console.consoleId}>
                            <td style={{ border: '1px solid #ddd', padding: '8px' }}>{console.consoleId}</td>
                            <td style={{ border: '1px solid #ddd', padding: '8px' }}>{console.consoleName}</td>
                            <td style={{ border: '1px solid #ddd', padding: '8px' }}>{console.releaseDate}</td>
                            <td style={{ border: '1px solid #ddd', padding: '8px' }}>${console.price.toFixed(2)}</td>
                            <td style={{ border: '1px solid #ddd', padding: '8px' }}>{console.quantityInStock}</td>
                            <td style={{ border: '1px solid #ddd', padding: '8px' }}>{console.company}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            ) : (
                <p>No consoles available.</p>
            )}
        </div>
    );
}
