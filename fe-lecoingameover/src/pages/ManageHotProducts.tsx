import { useState, useEffect } from "react";
import axios from "axios";
import "./ManageHotProducts.css";
import { ProductResponseModel } from "../Models/ProductResponseModel";

export default function ManageHotProducts(): JSX.Element {
  const [products, setProducts] = useState<ProductResponseModel[]>([]);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async (): Promise<void> => {
    try {
      const response = await axios.get("http://localhost:8080/api/v1/products");
      if (response.status === 200) {
        setProducts(response.data);
      }
    } catch (err) {
      console.error("Error fetching products:", err);
      setError("Failed to fetch products.");
    }
  };

  const toggleHotStatus = async (productId: string): Promise<void> => {
    try {
      await axios.put(`http://localhost:8080/api/v1/products/${productId}/hot`);
      setProducts((prevProducts) =>
        prevProducts.map((product) =>
          product.productId === productId
            ? { ...product, isHot: !product.isHot }
            : product
        )
      );
    } catch (err) {
      console.error("Error toggling hot status:", err);
      setError("Failed to update product.");
    }
  };

  return (
    <div className="products-container">
      <h1>Manage Hot Products</h1>
      {error && <p className="error-message">{error}</p>}

      <div className="products-category">
        <h2>Hot Products</h2>
        <div className="products-grid">
          {products
            .filter((product) => product.isHot)
            .map((product) => (
              <div key={product.productId} className="product-card">
                <img
                  src={product.image}
                  alt={product.productName}
                  className="product-image"
                />
                <h3>{product.productName}</h3>
                <p>{product.productDescription}</p>
                <p>Price: ${product.productSalePrice.toFixed(2)}</p>
                <button
                  className="toggle-hot-button"
                  onClick={() => toggleHotStatus(product.productId)}
                >
                  Remove from Hot Products
                </button>
              </div>
            ))}
        </div>
      </div>

      <div className="products-category">
        <h2>Non-Hot Products</h2>
        <div className="products-grid">
          {products
            .filter((product) => !product.isHot)
            .map((product) => (
              <div key={product.productId} className="product-card">
                <img
                  src={product.image}
                  alt={product.productName}
                  className="product-image"
                />
                <h3>{product.productName}</h3>
                <p>{product.productDescription}</p>
                <p>Price: ${product.productSalePrice.toFixed(2)}</p>
                <button
                  className="toggle-hot-button"
                  onClick={() => toggleHotStatus(product.productId)}
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
