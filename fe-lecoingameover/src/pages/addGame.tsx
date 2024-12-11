// AddGame.tsx
import { useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';
import './Games.css';

export default function AddGame(): JSX.Element {
    const { consoleId } = useParams<{ consoleId: string }>();
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        productName: '',
        productSalePrice: '',
        productDescription: '',
        genre: '',
        productQuantity: '',
    });
    const [error, setError] = useState<string | null>(null);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await axios.post(`http://localhost:8080/api/v1/products/console/${consoleId}`, {
                ...formData,
                productSalePrice: parseFloat(formData.productSalePrice),
                productQuantity: parseInt(formData.productQuantity),
            });
            navigate(`/games/${consoleId}`);
        } catch (err) {
            console.error('Error adding product:', err);
            setError('Failed to add game.');
        }
    };

    return (
        <div className="add-game-container">
            <h1>Add Game</h1>
            {error && <p className="add-game-error">{error}</p>}
            <form onSubmit={handleSubmit}>
                <label>
                    Name:
                    <input
                        type="text"
                        name="productName"
                        value={formData.productName}
                        onChange={handleChange}
                        required
                    />
                </label>
                <label>
                    Price:
                    <input
                        type="number"
                        name="productSalePrice"
                        value={formData.productSalePrice}
                        onChange={handleChange}
                        required
                    />
                </label>
                <label>
                    Description:
                    <textarea
                        name="productDescription"
                        value={formData.productDescription}
                        onChange={handleChange}
                        required
                    />
                </label>
                <label>
                    Genre:
                    <input
                        type="text"
                        name="genre"
                        value={formData.genre}
                        onChange={handleChange}
                        required
                    />
                </label>
                <label>
                    Quantity:
                    <input
                        type="number"
                        name="productQuantity"
                        value={formData.productQuantity}
                        onChange={handleChange}
                        required
                    />
                </label>
                <button type="submit">Add Game</button>
            </form>
        </div>
    );
}
