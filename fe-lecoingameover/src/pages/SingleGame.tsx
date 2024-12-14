import { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import './SingleGame.css';


export default function ProductDetails(): JSX.Element {
    const { productId } = useParams<{ productId: string }>();
    const [product, setProduct] = useState<any | null>(null);
    const [error, setError] = useState<string | null>(null);
    const navigate = useNavigate();


    useEffect(() => {
        fetchProductDetails();
    }, [productId]);


    const fetchProductDetails = async (): Promise<void> => {
        try {
            const response = await axios.get(`http://localhost:8080/api/v1/products/${productId}`);
            if (response.status === 200) {
                setProduct(response.data);
            }
        } catch (err) {
            console.error("Error fetching product details:", err);
            setError("Failed to fetch product details.");
        }
    };


    return (
        <div className="products-container">
            {error ? (
                <p className="products-error">{error}</p>
            ) : product ? (
                <div className="product-details-card">
                    <h1 className="products-title">{product.productName}</h1>
                    <div className="product-details-content">


                        <p>
                            <strong>Price:</strong> ${product.productSalePrice.toFixed(2)}
                        </p>
                        <p>
                            <strong>Description:</strong> {product.productDescription}
                        </p>
                        <p>
                            <strong>Genre:</strong> {product.genre}
                        </p>
                        <p>
                            <strong>Quantity:</strong> {product.productQuantity}
                        </p>


                    </div>
                    <button
                        className="add-game-button"
                        onClick={() => navigate(-1)}
                    >
                        Back
                    </button>
                </div>
            ) : (
                <p>Loading product details...</p>
            )}
        </div>
    );
}

