import React, { useEffect, useState } from 'react';
import './HomePage.css';
import Slider from "react-slick";
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

interface HotProduct {
  id: string;
  image: string;
  name: string;
  description: string;
  message?: string;
}

const HomePage: React.FC = () => {
  const [hotProducts, setHotProducts] = useState<HotProduct[]>([]);
  const [error, setError] = useState<string | null>(null);
  const navigate = useNavigate();

  useEffect(() => {
    // Fetch hot products from the backend
    const fetchHotProducts = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/v1/products/hot");
        setHotProducts(response.data);
      } catch (err) {
        console.error("Error fetching hot products:", err);
        setError("Failed to load hot products.");
      }
    };

    fetchHotProducts();
  }, []);

  const sliderSettings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,
    arrows: true,
  };

  const handleManageHotProducts = () => {
    navigate('/managehotproducts');
  }

  const handleNavigate = () => {
    navigate('/consoles');
  };

  return (
    <div className="home-page">
      {/* Hero Section */}
      <section className="hero-section">
        <h1>Bienvenue au Coin Game Over!</h1>
        <input type="text" placeholder="Que cherchez vous?" className="search-bar" />
        <h2>Tendances</h2>
        
        {/* Hot Products Carousel */}
        <div className="hot-products-carousel">
          {error && <p className="error-message">{error}</p>}
          <Slider {...sliderSettings}>
            {hotProducts.map((product) => (
              <div key={product.id} className="carousel-slide">
                <img src={product.image} alt={product.name} className="product-image" />
                <div className="product-info">
                  <h2>{product.name}</h2>
                  <p>{product.description}</p>
                  {product.message && <p className="admin-message">{product.message}</p>}
                </div>
              </div>
            ))}
          </Slider>
          <button className="manage-button" onClick={handleManageHotProducts}>Gérer les produits tendances</button>
        </div>
      </section>

      {/* Shop Section */}
      <section className="shop-section">
        <h2>Magasiner par:</h2>
        <button className="shop-button" onClick={handleNavigate}>
          <img src="/assets/images/console-icon.png" alt="Console Icon" className="button-image" />
        </button>
      </section>

      {/* About Us Section */}
      <section className="about-section">
        <h3>À Propos De Nous</h3>
        <p>
          Le Coin Game Over est une boutique spécialisée dans les jeux vidéo et accessoires rétro et modernes. Nous proposons une vaste collection de consoles, de jeux classiques et récents, ainsi que des accessoires pour enrichir votre expérience de joueur. Avec une ambiance nostalgique et un service clientèle passionné, Le Coin Game Over est l’endroit idéal pour les amateurs de jeux vidéo, qu’ils soient collectionneurs ou joueurs occasionnels. Rejoignez-nous pour explorer un univers dédié à la culture vidéoludique!
        </p>
        <img src="/assets/images/StoreImage.png" alt="Store Interior" className="store-image" />
      </section>
    </div>
  );
};

export default HomePage;
