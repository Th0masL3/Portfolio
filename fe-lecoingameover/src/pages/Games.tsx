import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import './Games.css';
import {ProductResponseModel} from "../Models/ProductResponseModel";
import {ConsoleResponseModel} from "../Models/ConsoleResponseModel";


export default function Games(): JSX.Element {
    const { consoleId } = useParams<{ consoleId: string }>();
    const [products, setProducts] = useState<ProductResponseModel[]>([]);
    const [error, setError] = useState<string | null>(null);
    const [consoleDetails, setConsoleDetails] = useState<ConsoleResponseModel | null>(null);


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

    return (
        <div className="products-container">
            <h1 className="products-title">
                {consoleDetails ? `${consoleDetails.consoleName} Games` : 'Games'}
            </h1>
            {error && <p className="products-error">{error}</p>}
            <table className="products-table">
                <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Genre</th>
                    <th>Quantity</th>
                </tr>
                </thead>
                <tbody>
                {products.map((product) => (
                    <tr key={product.productId}>
                        <td>{product.productId}</td>
                        <td>{product.productName}</td>
                        <td>${product.productSalePrice.toFixed(2)}</td>
                        <td>{product.productDescription}</td>
                        <td>{product.genre}</td>
                        <td>{product.productQuantity}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}
