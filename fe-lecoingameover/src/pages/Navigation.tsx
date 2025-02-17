import React from 'react';
import { Link } from 'react-router-dom';
import { AppRoutes } from '../shared/models/app.routes';
import './Navigation.css';

const Navigation: React.FC = () => {
    return (
        <nav className="navbar">
            <h1 className="navbar-title">My Portfolio</h1>
            <ul className="navbar-links">
                <li><Link to={AppRoutes.Homepage} className="nav-link">Home</Link></li>
                <li><Link to={AppRoutes.About} className="nav-link">About Me</Link></li>
                <li><Link to={AppRoutes.Projects} className="nav-link">Projects</Link></li>
            </ul>
        </nav>
    );
};

export default Navigation;
