import React from 'react';
import './HomePage.css';
import { useNavigate } from 'react-router-dom';

const HomePage: React.FC = () => {

  const navigate = useNavigate();

  const handleNavigate = () => {
    navigate('/consoles');
  };

  return (
    <div className="home-page">

      {/* Hero Section */}
      <section className="hero-section">
        <h1>Bienvenu au Coin Game Over!</h1>
        <input type="text" placeholder="Que cherchez vous?" className="search-bar" />
        <h2>Tendances</h2>
      </section>

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
