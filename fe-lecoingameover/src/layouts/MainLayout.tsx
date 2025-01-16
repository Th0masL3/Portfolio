import React from 'react';
import { Outlet } from 'react-router-dom';
import Navigation from '../pages/Navigation';

const MainLayout: React.FC = () => {
    return (
        <>
            <Navigation />
            <main style={{ backgroundColor: '#8A00C4',
                height: '100vh',
             }}>
                <Outlet />
            </main>
        </>
    );
};

export default MainLayout;
