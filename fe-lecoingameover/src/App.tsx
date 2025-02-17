import "./App.css";
import { Suspense } from "react";
import { RouterProvider } from "react-router-dom";
import { LanguageProvider } from "./LanguageContext";
import router from "./router";

function App(): JSX.Element {
    return (
        <LanguageProvider>
            <Suspense fallback={<div>Loading...</div>}>
                <RouterProvider router={router} />
            </Suspense>
        </LanguageProvider>
    );
}

export default App;
