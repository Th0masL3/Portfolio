import {createBrowserRouter} from 'react-router-dom';
import Consoles from './pages/Consoles';
import EditConsole from './pages/EditConsole';
import {ProtectedRoute} from './shared/components/ProtectedRoute';
import {AppRoutes} from './shared/models/app.routes';
import AddConsole from './pages/AddConsole';
import Products from './pages/Products';

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
                        <Products/>
                    </ProtectedRoute>
                )
            }
        ],
    },
]);

export default router;
