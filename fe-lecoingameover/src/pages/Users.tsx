import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './Users.css';

export default function Users(): JSX.Element {
    const [users, setUsers] = useState<UserResponseModel[]>([]);
    const [error, setError] = useState<string | null>(null);
    const navigate = useNavigate();

    useEffect(() => {
        fetchUsers();
    }, []);

    const fetchUsers = async (): Promise<void> => {
        try {
            const response = await axios.get('http://localhost:8080/api/v1/users');
            if (response.status === 200) {
                setUsers(response.data);
            }
        } catch (err) {
            console.error('Error fetching users:', err);
            setError('Failed to fetch users.');
        }
    };

    const handleUserRowClick = (userId: string): void => {
        navigate(`/users/${userId}`);
    };

    const handleBlockUser = async (userId: string, blocked: boolean): Promise<void> => {
        try {
            // Update backend
            await axios.put(`http://localhost:8080/api/v1/users/${userId}/block`, null, {
                params: { isBlocked: blocked },
            });

            // Optimistically update local state
            setUsers((prevUsers) =>
              prevUsers.map((user) =>
                user.userId === userId ? { ...user, blocked } : user
              )
            );
            console.log(`User ${userId} is now ${blocked ? 'blocked' : 'unblocked'}.`);
        } catch (err) {
            console.error(`Error ${blocked ? 'blocking' : 'unblocking'} user:`, err);
            setError(`Failed to ${blocked ? 'block' : 'unblock'} user.`);
        }
    };

    return (
      <div className="users-container">
          <h1 className="users-title">User List</h1>
          {error && <p className="users-error">{error}</p>}
          <table className="users-table">
              <thead>
              <tr>
                  <th>User ID</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Email</th>
                  <th>Actions</th>
              </tr>
              </thead>
              <tbody>
              {users.map((user) => (
                <tr
                  key={user.userId}
                  onClick={() => handleUserRowClick(user.userId)}
                  style={{ cursor: 'pointer' }}
                >
                    <td>{user.userId}</td>
                    <td>{user.firstName}</td>
                    <td>{user.lastName}</td>
                    <td>{user.email}</td>
                    <td>
                        <button
                          onClick={(e) => {
                              e.stopPropagation(); // Prevent row click
                              handleBlockUser(user.userId, !user.blocked); // Toggle block/unblock
                          }}
                        >
                            {user.blocked ? 'Unblock' : 'Block'}
                        </button>
                    </td>
                </tr>
              ))}
              </tbody>
          </table>
      </div>
    );
}

// UserResponseModel TypeScript Interface
interface UserResponseModel {
    userId: string;
    firstName: string;
    lastName: string;
    email: string;
    blocked: boolean;
}
