import React, { useContext } from 'react';
import { Navigate } from 'react-router-dom';
import { AuthContext } from '../../context/AuthContext';
interface ProtectedRouteProps {
    element: JSX.Element;
    requiredRole: 'admin' | 'user';
}

const ProtectedRoute: React.FC<ProtectedRouteProps> = ({ element, requiredRole }) => {
    const auth = useContext(AuthContext);

    if (!auth?.user || auth.user.role !== requiredRole) {
        return <Navigate to="/" />;
    }

    return element;
};

export default ProtectedRoute;
