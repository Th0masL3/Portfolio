import {createBrowserRouter} from 'react-router-dom';
import Consoles from './pages/Consoles';
import EditConsole from './pages/EditConsole';
import {ProtectedRoute} from './shared/components/ProtectedRoute';
import { AppRoutes } from './shared/models/app.routes';
import AddConsole from './pages/AddConsole';
import Games from './pages/Games';
import AddGame from './pages/addGame';
import HomePage from './pages/HomePage';
import UpdateGame from './pages/UpdateGame';
import MainLayout from './layouts/MainLayout';
import SingleGame from './pages/SingleGame'
import Users from "./pages/Users";
import Cart from './pages/Cart';
import UserProfile from "./pages/UserProfile";
import CheckoutSuccess from "./pages/CheckoutSuccess";


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
            path: AppRoutes.Users,
            element: (
              <ProtectedRoute>
                <Users />
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
            },
            {
                path: AppRoutes.SingleGame,
                element: (
                    <ProtectedRoute>
                        <SingleGame />
                    </ProtectedRoute>
                ),
            },
            
            {

                path: AppRoutes.Cart,  // Define the Cart route
                element: (
                    <ProtectedRoute>
                        <Cart />
                    </ProtectedRoute>
                ),
            },



   {
                path: AppRoutes.UserProfile, // Add the profile page route
                element: (
                  <ProtectedRoute>
                      <UserProfile />
                  </ProtectedRoute>
                ),
            },
            {
                path: AppRoutes.CheckoutSuccess,
                element: (
                    <ProtectedRoute>
                        <CheckoutSuccess/>
                    </ProtectedRoute>
                )
            }

        ],
    },
]);

export default router;
