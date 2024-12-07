import { useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Consoles.css';

interface ConsoleRequestModel {
    consoleName: string;
    releaseDate: string;
    price: number;
    quantityInStock: number;
    company: string;
}

export default function EditConsole(): JSX.Element {
    const location = useLocation();
    const navigate = useNavigate();

    const console = location.state?.console;
    const [formData, setFormData] = useState<ConsoleRequestModel>({
        consoleName: console?.consoleName || '',
        releaseDate: console?.releaseDate || '',
        price: console?.price || 0,
        quantityInStock: console?.quantityInStock || 0,
        company: console?.company || '',
    });

    const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setFormData((prevState) => ({
            ...prevState,
            [name]: name === 'price' || name === 'quantityInStock' ? Number(value) : value,
        }));
    };

    const handleFormSubmit = async (event: React.FormEvent) => {
        event.preventDefault();

        try {
            const response = await axios.put(
                `http://localhost:8080/api/v1/consoles/${console.consoleId}`,
                formData
            );
            if (response.status === 200) {
                navigate('/consoles');
            }
        } catch (err) {
            console.error('Error updating console:', err);
            alert('Failed to update the console. Please try again.');
        }
    };

    return (
        <div className="console-edit-container">
            <h1 className="console-title">Edit Console</h1>
            <form onSubmit={handleFormSubmit}>
                <div className="form-group">
                    <label>Name</label>
                    <input
                        type="text"
                        name="consoleName"
                        value={formData.consoleName}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="form-group">
                    <label>Release Date</label>
                    <input
                        type="date"
                        name="releaseDate"
                        value={formData.releaseDate}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="form-group">
                    <label>Price</label>
                    <input
                        type="number"
                        name="price"
                        value={formData.price}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="form-group">
                    <label>Quantity</label>
                    <input
                        type="number"
                        name="quantityInStock"
                        value={formData.quantityInStock}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="form-group">
                    <label>Company</label>
                    <input
                        type="text"
                        name="company"
                        value={formData.company}
                        onChange={handleInputChange}
                    />
                </div>
                <button type="submit" className="console-button">
                    Save
                </button>
                <button
                    type="button"
                    className="console-button-cancel"
                    onClick={() => navigate('/consoles')}
                >
                    Cancel
                </button>
            </form>
        </div>
    );
}
