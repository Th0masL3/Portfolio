import React from 'react';
import { Outlet } from 'react-router-dom';
import Navigation from '../pages/Navigation';
import Footer from '../pages/Footer';
import './MainLayout.css';

const MainLayout: React.FC = () => {
    return (
        <>
            <Navigation />
            <main className="main-container">
                <Outlet />
            </main>
            <Footer />
        </>
    );
};

export default MainLayout;
