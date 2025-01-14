import React from 'react';
import { Outlet } from 'react-router-dom';
import Navigation from '../pages/Navigation';

const MainLayout: React.FC = () => {
    return (
        <>
            <Navigation />
            <main style={{ padding: '1rem' }}>
                <Outlet />
            </main>
        </>
    );
};

export default MainLayout;
