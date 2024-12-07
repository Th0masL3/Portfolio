import { createBrowserRouter } from 'react-router-dom';
import Consoles from './pages/Products';
import EditConsole from './pages/EditConsole';
import { ProtectedRoute } from './shared/components/ProtectedRoute';
import { AppRoutes } from './shared/models/app.routes';

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
            },
            {
                path: AppRoutes.EditConsole,
                element: (
                    <ProtectedRoute>
                        <EditConsole />
                    </ProtectedRoute>
                ),
            },
        ],
    },
]);

export default router;
