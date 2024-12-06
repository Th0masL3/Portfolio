import {createBrowserRouter} from "react-router-dom";
import {AppRoutes} from "./shared/models/app.routes";
import Consoles from "./pages/Products";
import {ProtectedRoute} from "./shared/components/ProtectedRoute";
const router = createBrowserRouter([
    {
        children: [
            {
                path: AppRoutes.ConsoleList,
                element: (
                    <ProtectedRoute>
                        <Consoles />
                    </ProtectedRoute>
                ),
            }

        ],
    },
]);
export default router;