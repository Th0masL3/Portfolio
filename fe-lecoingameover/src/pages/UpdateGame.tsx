import { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';
import './Games.css';

export default function UpdateGame(): JSX.Element {
    const { productId } = useParams<{ productId: string }>();
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        productName: '',
        productSalePrice: '',
        productDescription: '',
        genre: '',
        productQuantity: '',
        image: '',
        console: {
            consoleId: '',
            consoleName: '',
            releaseDate: '',
            price: '',
            quantityInStock: '',
            company: '',
        },
    });
    const [error, setError] = useState<string | null>(null);

    // Fetch product details on component mount
    useEffect(() => {
        const fetchProductDetails = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/v1/products/${productId}`);
                if (response.status === 200) {
                    setFormData(response.data);
                }
            } catch (err) {
                console.error('Error fetching product details:', err);
                setError('Failed to fetch product details.');
            }
        };

        fetchProductDetails();
    }, [productId]);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        const { name, value } = e.target;
        if (name in formData.console) {
            setFormData({
                ...formData,
                console: { ...formData.console, [name]: value },
            });
        } else {
            setFormData({ ...formData, [name]: value });
        }
    };

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        try {
            await axios.put(`http://localhost:8080/api/v1/products/${productId}`, {
                ...formData,
                productSalePrice: parseFloat(formData.productSalePrice),
                productQuantity: parseInt(formData.productQuantity),
            });
            navigate(`/consoles/${formData.console.consoleId}/products`); // Redirect to the correct URL
        } catch (err) {
            console.error('Error updating product:', err);
            setError('Failed to update product.');
        }
    };

    return (
        <div className="add-game-container">
            <h1>Update Game</h1>
            {error && <p className="add-game-error">{error}</p>}
            <form onSubmit={handleSubmit}>
                {/* Product fields */}
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
                <label>
                    Image Link:
                    <input
                        type="text"
                        name="image"
                        value={formData.image}
                        onChange={handleChange}
                    />
                </label>

                {/* Console details (read-only except for ID) */}
                <fieldset>
                    <legend>Console Details</legend>
                    <label>
                        Console ID:
                        <input
                            type="text"
                            name="consoleId"
                            value={formData.console.consoleId}
                            readOnly
                        />
                    </label>
                    <label>
                        Console Name:
                        <input
                            type="text"
                            name="consoleName"
                            value={formData.console.consoleName}
                            readOnly
                        />
                    </label>
                    <label>
                        Release Date:
                        <input
                            type="date"
                            name="releaseDate"
                            value={formData.console.releaseDate}
                            readOnly
                        />
                    </label>
                    <label>
                        Price:
                        <input
                            type="number"
                            name="price"
                            value={formData.console.price}
                            readOnly
                        />
                    </label>
                    <label>
                        Quantity in Stock:
                        <input
                            type="number"
                            name="quantityInStock"
                            value={formData.console.quantityInStock}
                            readOnly
                        />
                    </label>
                    <label>
                        Company:
                        <input
                            type="text"
                            name="company"
                            value={formData.console.company}
                            readOnly
                        />
                    </label>
                </fieldset>

                <button type="submit">Update Game</button>
            </form>
        </div>
    );
}
