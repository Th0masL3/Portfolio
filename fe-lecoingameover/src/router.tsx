import {createBrowserRouter} from 'react-router-dom';
import Home from './pages/Home';
import About from './pages/AboutMe';
import Projects from './pages/Projects';
import MainLayout from './layouts/MainLayout';
import {AppRoutes} from './shared/models/app.routes';
import Login from "./pages/Login";
import Comments from "./pages/Comments";
import ProtectedRoute from './shared/components/ProtectedRoute';
import PublicComment from "./pages/PublicComment";
import AdminAboutMe from "./pages/AdminAboutMe";
import AdminProjects from "./pages/AdminProjects";


const router = createBrowserRouter([
    {
        element: <MainLayout />,
        children: [
            {
                path: AppRoutes.Homepage,
                element: <Home />,
            },
            {
                path: AppRoutes.About,
                element: <About />,
            },
            {
                path: AppRoutes.Projects,
                element: <Projects />,
            },
            {
                path: AppRoutes.Login,
                element: <Login />,
            },
            {
                path: AppRoutes.Comments,
                element: <ProtectedRoute element={<Comments />} requiredRole="admin" />,
            },
            {
                path: AppRoutes.PublicComment,
                element: <PublicComment/>
            },
            {
                path: AppRoutes.AdminAboutMe,
                element: <AdminAboutMe/>
            },
            {
                path: AppRoutes.AdminProjects,
                element: <AdminProjects/>
            }

        ],
    },
]);

export default router;
