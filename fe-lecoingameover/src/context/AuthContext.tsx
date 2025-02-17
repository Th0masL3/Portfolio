import React, { createContext, useState, useEffect } from 'react';

interface User {
    username: string;
    role: 'admin' | 'user';
}

interface AuthContextType {
    user: User | null;
    login: (username: string, password: string) => boolean;
    logout: () => void;
}

export const AuthContext = createContext<AuthContextType | null>(null);

export const AuthProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
    const [user, setUser] = useState<User | null>(null);

    useEffect(() => {
        try {
            const storedUser = localStorage.getItem('authUser');
            if (storedUser) {
                setUser(JSON.parse(storedUser));
            }
        } catch (error) {
            console.error("Error accessing localStorage:", error);
        }
    }, []);

    const login = (username: string, password: string): boolean => {
        const lowerUsername = username.toLowerCase();

        // Frontend-only authentication
        const validUsers: Record<string, { password: string; role: 'admin' | 'user' }> = {
            admin: { password: 'admin123', role: 'admin' },
            user: { password: 'user123', role: 'user' },
        };

        console.log("🔍 Checking credentials for:", lowerUsername, password);

        if (validUsers[lowerUsername] && validUsers[lowerUsername].password === password) {
            console.log("✅ Login successful!");
            const userData: User = { username: lowerUsername, role: validUsers[lowerUsername].role };
            try {
                localStorage.setItem('authUser', JSON.stringify(userData));
            } catch (error) {
                console.error("Error saving to localStorage:", error);
            }
            setUser(userData);
            return true;
        }

        console.log("❌ Authentication failed for:", lowerUsername);
        return false;
    };

    const logout = () => {
        console.log("👋 Logging out:", user);
        try {
            localStorage.removeItem('authUser');
        } catch (error) {
            console.error("Error removing from localStorage:", error);
        }
        setUser(null);
    };

    return (
        <AuthContext.Provider value={{ user, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};
