import React, { useState, useContext } from 'react';
import { AuthContext } from '../context/AuthContext';
import { useNavigate } from 'react-router-dom';
import { useLanguage } from "../LanguageContext";
import './Login.css';

const LoginPage: React.FC = () => {
    const { t } = useLanguage();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const auth = useContext(AuthContext);
    const navigate = useNavigate();

    const handleLogin = () => {
        if (!auth) {
            console.error("AuthContext not available.");
            return;
        }

        console.log("Attempting login with:", username, password);
        if (auth.login(username.trim(), password.trim())) {
            navigate('/');
        } else {
            setError(t("loginError"));
        }
    };

    return (
        <form className="login-form" onSubmit={(e) => { e.preventDefault(); handleLogin(); }}>
            <h2>{t("loginTitle")}</h2>
            {error && <p className="error-message">{error}</p>}

            <div className="input-group">
                <label htmlFor="username">{t("usernameLabel")}</label>
                <input
                    type="text"
                    id="username"
                    className="login-input"
                    placeholder={t("usernamePlaceholder")}
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                    required
                />
            </div>

            <div className="input-group">
                <label htmlFor="password">{t("passwordLabel")}</label>
                <input
                    type="password"
                    id="password"
                    className="login-input"
                    placeholder={t("passwordPlaceholder")}
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />
            </div>

            <button type="submit" className="login-button">{t("loginButton")}</button>
        </form>
    );
};

export default LoginPage;
