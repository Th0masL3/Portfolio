import { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import "./Games.css";
import { ProductResponseModel } from "../Models/ProductResponseModel";
import { ConsoleResponseModel } from "../Models/ConsoleResponseModel";

export default function Games(): JSX.Element {
    const { consoleId } = useParams<{ consoleId: string }>();
    const [products, setProducts] = useState<ProductResponseModel[]>([]);
    const [consoleDetails, setConsoleDetails] = useState<ConsoleResponseModel | null>(null);
    const [error, setError] = useState<string | null>(null);
    const navigate = useNavigate();

    useEffect(() => {
        fetchConsoleDetails();
        fetchProducts();
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [consoleId]);

    const fetchConsoleDetails = async (): Promise<void> => {
        try {
            const response = await axios.get(`http://localhost:8080/api/v1/consoles/${consoleId}`);
            if (response.status === 200) {
                setConsoleDetails(response.data);
            }
        } catch (err) {
            console.error("Error fetching console details:", err);
            setError("Failed to fetch console details.");
        }
    };
    const addToCart = async (productId: string): Promise<void> => {
  try {
    const productRequest = products.find((p) => p.productId === productId);
    if (!productRequest) return;

    const response = await axios.post(
      `http://localhost:8080/api/v1/cart/product/${productId}`,
      {
        productId: productRequest.productId,
        productName: productRequest.productName,
        productSalePrice: productRequest.productSalePrice,
        productDescription: productRequest.productDescription,
        genre: productRequest.genre,
        productQuantity: productRequest.productQuantity,
        image: productRequest.image,
      }
    );
    if (response.status === 201) {
      alert("Game added to cart!");
    }
  } catch (err) {
    console.error("Error adding to cart:", err);
    setError("Failed to add game to cart.");
  }
};


    const fetchProducts = async (): Promise<void> => {
        try {
            const response = await axios.get(`http://localhost:8080/api/v1/products/console/${consoleId}`);
            if (response.status === 200) {
                setProducts(response.data);
            }
        } catch (err) {
            console.error("Error fetching products:", err);
            setError("Failed to fetch products.");
        }
    };

    const handleCardClick = (productId: string) => {
        navigate(`/products/${productId}`);
    };

    const handleAddProductClick = () => {
        navigate(`/add-game/${consoleId}`);
    };

    const handleUpdateProductClick = (event: React.MouseEvent, productId: string) => {
        event.stopPropagation(); // Prevent parent click
        navigate(`/update-game/${productId}`);
    };

    const handleDeleteProductClick = async (event: React.MouseEvent, productId: string) => {
        event.stopPropagation(); // Prevent parent click
        const confirmed = window.confirm("Are you sure you want to delete this product?");
        if (confirmed) {
            try {
                await axios.delete(`http://localhost:8080/api/v1/products/${productId}`);
                setProducts((prevProducts) => prevProducts.filter((product) => product.productId !== productId));
                alert("Product deleted successfully!");
            } catch (err) {
                console.error("Error deleting product:", err);
                setError("Failed to delete the product.");
            }
        }
    };


    return (
        <div className="products-container">
            <h1 className="products-title">
                {consoleDetails ? `${consoleDetails.consoleName} Games` : "Games"}
            </h1>
            {error && <p className="products-error">{error}</p>}
            <button className="add-product-button" onClick={handleAddProductClick}>
                Add Game
            </button>
            <div className="products-grid">
                {products.map((product) => (
                    <div
                        key={product.productId}
                        className="product-card"
                        onClick={() => handleCardClick(product.productId)}
                    >
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
                        <div className="product-card-actions">
                            <button onClick={() => addToCart(product.productId)}>Add to Cart</button>
                            <button
                                className="product-button"
                                onClick={(event) => handleUpdateProductClick(event, product.productId)}
                            >
                                Update
                            </button>
                            <button
                                className="product-button delete-button"
                                onClick={(event) => handleDeleteProductClick(event, product.productId)}
                            >
                                Delete
                            </button>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
}
