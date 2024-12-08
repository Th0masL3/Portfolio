import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './Consoles.css';

interface ConsoleRequestModel {
    consoleName: string;
    releaseDate: string;
    price: number;
    quantityInStock: number;
    company: string;
}

export default function AddConsole(): JSX.Element {
    const navigate = useNavigate();

    const [formData, setFormData] = useState<ConsoleRequestModel>({
        consoleName: '',
        releaseDate: '',
        price: 0,
        quantityInStock: 0,
        company: '',
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
            const response = await axios.post(
                `http://localhost:8080/api/v1/consoles`,
                formData
            );
            if (response.status === 201) {
                alert('Console created successfully!');
                navigate('/consoles');
            }
        } catch (err) {
            console.error('Error adding console:', err);
            alert('Failed to add the console. Please try again.');
        }
    };

    return (
        <div className="console-add-container">
            <h1 className="console-title">Add Console</h1>
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
                    Add
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
