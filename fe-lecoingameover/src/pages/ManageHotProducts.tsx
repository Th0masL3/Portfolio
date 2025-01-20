import { useState, useEffect } from "react";
import axios from "axios";
import "./Games.css";
import { ProductResponseModel } from "../Models/ProductResponseModel";

export default function ManageHotProducts(): JSX.Element {
    const [products, setProducts] = useState<ProductResponseModel[]>([]);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        fetchProducts();
    }, []);

    const fetchProducts = async (): Promise<void> => {
        try {
            const response = await axios.get(`http://localhost:8080/api/v1/products`);
            if (response.status === 200) {
                setProducts(response.data);
            }
        } catch (err) {
            console.error("Error fetching products:", err);
            setError("Failed to fetch products.");
        }
    };

    const toggleHotProduct = async (productId: string) => {
        try {
            await axios.put(`http://localhost:8080/api/v1/products/${productId}/hot`);
            // Refresh the page by refetching products
            fetchProducts();
        } catch (err) {
            console.error("Error toggling hot product:", err);
            setError("Failed to update the product.");
        }
    };

    const hotProducts = products.filter((product) => product.isHot);
    const nonHotProducts = products.filter((product) => !product.isHot);

    return (
        <div className="manage-hot-products">
            <h1 className="section-title">Manage Hot Products</h1>
            {error && <p className="error-message">{error}</p>}

            {/* Hot Products Section */}
            <div className="hot-products-container">
                <h2 className="section-title">Hot Products</h2>
                <div className="products-grid">
                    {hotProducts.map((product) => (
                        <div key={product.productId} className="product-card">
                            <img
                                src={product.image}
                                alt={product.productName}
                                className="product-card-image"
                            />
                            <h3>{product.productName}</h3>
                            <p>Price: ${product.productSalePrice.toFixed(2)}</p>
                            <p>{product.productDescription}</p>
                            <p>Genre: {product.genre}</p>
                            <button
                                className="product-button"
                                onClick={() => toggleHotProduct(product.productId)}
                            >
                                Remove from Hot Products
                            </button>
                        </div>
                    ))}
                </div>
            </div>

            {/* Non-Hot Products Section */}
            <div className="non-hot-products-container">
                <h2 className="section-title">Non-Hot Products</h2>
                <div className="products-grid">
                    {nonHotProducts.map((product) => (
                        <div key={product.productId} className="product-card">
                            <img
                                src={product.image}
                                alt={product.productName}
                                className="product-card-image"
                            />
                            <h3>{product.productName}</h3>
                            <p>Price: ${product.productSalePrice.toFixed(2)}</p>
                            <p>{product.productDescription}</p>
                            <p>Genre: {product.genre}</p>
                            <button
                                className="product-button"
                                onClick={() => toggleHotProduct(product.productId)}
                            >
                                Add to Hot Products
                            </button>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}
