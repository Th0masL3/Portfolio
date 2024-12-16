import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import Navigation from "./Navigation";
import axios from 'axios';
import './Games.css';
import { ProductResponseModel } from "../Models/ProductResponseModel";
import { ConsoleResponseModel } from "../Models/ConsoleResponseModel";

export default function Games(): JSX.Element {
    const { consoleId } = useParams<{ consoleId: string }>();
    const [products, setProducts] = useState<ProductResponseModel[]>([]);
    const [error, setError] = useState<string | null>(null);
    const [consoleDetails, setConsoleDetails] = useState<ConsoleResponseModel | null>(null);
    const navigate = useNavigate();

    useEffect(() => {
        fetchConsoleDetails();
        fetchProducts();
    }, [consoleId]);

    const fetchConsoleDetails = async (): Promise<void> => {
        try {
            const response = await axios.get(`http://localhost:8080/api/v1/consoles/${consoleId}`);
            if (response.status === 200) {
                setConsoleDetails(response.data);
            }
        } catch (err) {
            console.error('Error fetching console details:', err);
            setError('Failed to fetch console details.');
        }
    };

    const fetchProducts = async (): Promise<void> => {
        try {
            const response = await axios.get(`http://localhost:8080/api/v1/products/console/${consoleId}`);
            if (response.status === 200) {
                setProducts(response.data);
            }
        } catch (err) {
            console.error('Error fetching products:', err);
            setError('Failed to fetch products.');
        }
    };

    const handleProductRowClick = (productId: string) => {
        navigate(`/products/${productId}`);
    };

    const handleAddGameClick = (): void => {
        navigate(`/add-game/${consoleId}`);
    };

    const handleUpdateGameClick = (event: React.MouseEvent, productId: string): void => {
        event.stopPropagation();
        navigate(`/update-game/${productId}`);
    };

    const handleDeleteGameClick = async (event: React.MouseEvent, productId: string): Promise<void> => {
        event.stopPropagation();
        const confirmed = window.confirm("Are you sure you want to delete this product?");
        if (confirmed) {
            try {
                await axios.delete(`http://localhost:8080/api/v1/products/${productId}`);
                setProducts(products.filter((product) => product.productId !== productId));
            } catch (err) {
                console.error('Error deleting product:', err);
                setError('Failed to delete the product.');
            }
        }
    };

    return (
        <div className="products-container">
            <h1 className="products-title">
                {consoleDetails ? `${consoleDetails.consoleName} Games` : 'Games'}
            </h1>
            {error && <p className="products-error">{error}</p>}
            <button className="add-game-button" onClick={handleAddGameClick}>Add Game</button>
            <table className="products-table">
                <thead>
                    <tr>
                        <th>Product ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Genre</th>
                        <th>Quantity</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {products.map((product) => (
                        <tr
                            key={product.productId}
                            onClick={() => handleProductRowClick(product.productId)}
                            style={{ cursor: "pointer" }}
                        >
                            <td>{product.productId}</td>
                            <td>{product.productName}</td>
                            <td>${product.productSalePrice.toFixed(2)}</td>
                            <td>{product.productDescription}</td>
                            <td>{product.genre}</td>
                            <td>{product.productQuantity}</td>
                            <td>
                                <button
                                    className="update-game-button"
                                    onClick={(event) => handleUpdateGameClick(event, product.productId)}
                                >
                                    Update
                                </button>
                                <button
                                    className="delete-game-button"
                                    onClick={(event) => handleDeleteGameClick(event, product.productId)}
                                >
                                    Delete
                                </button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}
