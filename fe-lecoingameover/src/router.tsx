import {createBrowserRouter} from 'react-router-dom';
import Consoles from './pages/Consoles';
import EditConsole from './pages/EditConsole';
import {ProtectedRoute} from './shared/components/ProtectedRoute';
import { AppRoutes } from './shared/models/app.routes';
import AddConsole from './pages/AddConsole';
import Games from './pages/Games.tsx';
import AddGame from './pages/addGame.tsx';
import HomePage from './pages/HomePage';
import UpdateGame from './pages/UpdateGame.tsx';
import MainLayout from './layouts/MainLayout';

const router = createBrowserRouter([
    {
        element: <MainLayout />,
        children: [
            {
                path: AppRoutes.Homepage,
                element: (
                    <ProtectedRoute>
                        <HomePage />
                    </ProtectedRoute>
                ),
            },
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
            },
            {
                path: AppRoutes.AddGame,
                element: (
                    <ProtectedRoute>
                        <AddGame />
                    </ProtectedRoute>
                ),
            },
            {
                path: "/update-game/:productId",
                element: (
                    <ProtectedRoute>
                        <UpdateGame />
                    </ProtectedRoute>
                ),
            }
           
            
        ],
    },
]);

export default router;
