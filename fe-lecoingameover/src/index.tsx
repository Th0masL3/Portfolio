import React from 'react';
import ReactDOM from 'react-dom/client';
import { Auth0Provider } from '@auth0/auth0-react';
import App from './App';
import './index.css';
import reportWebVitals from './reportWebVitals';
import 'bootstrap/dist/css/bootstrap.min.css';

// Replace these with your Auth0 credentials
const domain = "dev-pgf67fhh21tkyd1v.us.auth0.com";
const clientId = "KhxrQwX2k8C0QWx2ogzl5pcZzBNXl9hk";

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

root.render(
  <React.StrictMode>
    <Auth0Provider
      domain={domain}
      clientId={clientId}
      authorizationParams={{
        redirect_uri: window.location.origin,
      }}
    >
      <App />
    </Auth0Provider>
  </React.StrictMode>
);

reportWebVitals();
