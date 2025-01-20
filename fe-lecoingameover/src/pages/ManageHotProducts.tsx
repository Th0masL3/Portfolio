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
            const response = await axios.get(`http://localhost:8080/api/v1/products/`);
            if (response.status === 200) {
                setProducts(response.data);
            }
        } catch (err) {
            console.error("Error fetching products:", err);
            setError("Failed to fetch products.");
        }
    };

    const toggleHotStatus = async (productId: string) => {
        try {
            await axios.put(`http://localhost:8080/api/v1/products/${productId}/hot`);
            setProducts((prevProducts) =>
                prevProducts.map((product) =>
                    product.productId === productId ? { ...product, hot: !product.isHot } : product
                )
            );
        } catch (err) {
            console.error("Error toggling hot status:", err);
            setError("Failed to toggle hot status.");
        }
    };

    const hotProducts = products.filter((product) => product.isHot);
    const nonHotProducts = products.filter((product) => !product.isHot);

    return (
        <div className="products-container">
            <h1 className="products-title">Manage Hot Products</h1>
            {error && <p className="products-error">{error}</p>}

            {/* Hot Products Section */}
            <section>
                <h2>Hot Products</h2>
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
                            <p>Stock: {product.productQuantity}</p>
                            <button
                                className="product-button toggle-hot-button"
                                onClick={() => toggleHotStatus(product.productId)}
                            >
                                Remove from Hot
                            </button>
                        </div>
                    ))}
                </div>
            </section>

            {/* Non-Hot Products Section */}
            <section>
                <h2>Non-Hot Products</h2>
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
                            <p>Stock: {product.productQuantity}</p>
                            <button
                                className="product-button toggle-hot-button"
                                onClick={() => toggleHotStatus(product.productId)}
                            >
                                Add to Hot
                            </button>
                        </div>
                    ))}
                </div>
            </section>
        </div>
    );
}
