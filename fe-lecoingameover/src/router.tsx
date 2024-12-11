import {createBrowserRouter} from 'react-router-dom';
import Consoles from './pages/Consoles';
import EditConsole from './pages/EditConsole';
import {ProtectedRoute} from './shared/components/ProtectedRoute';
import {AppRoutes} from './shared/models/app.routes';
import AddConsole from './pages/AddConsole';
import Games from './pages/Games.tsx';

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
            {
                path: AppRoutes.AddConsole,
                element: (
                    <ProtectedRoute>
                        <AddConsole />
                    </ProtectedRoute>
                ),
            },
            {
                path: AppRoutes.Products,
                element: (
                    <ProtectedRoute>
                        <Games/>
                    </ProtectedRoute>
                )
            }
        ],
    },
]);

export default router;
