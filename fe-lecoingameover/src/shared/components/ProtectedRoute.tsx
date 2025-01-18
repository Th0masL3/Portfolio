import { ReactNode } from 'react';
interface ProtectedRoutes {
    children: ReactNode;
}
export const ProtectedRoute = ({
                                   children,
                               }: ProtectedRoutes): JSX.Element => {
    return <>{children}</>;
};