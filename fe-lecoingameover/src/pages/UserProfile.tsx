import React, { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import axios from 'axios';
import './UserProfile.css';

export default function UserProfile(): JSX.Element {
  const { userId } = useParams<{ userId: string }>();
  const [user, setUser] = useState<UserResponseModel | null>(null);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    fetchUserProfile();
  }, [userId]);

  const fetchUserProfile = async (): Promise<void> => {
    try {
      const response = await axios.get(`http://localhost:8080/api/v1/users/${userId}`);
      if (response.status === 200) {
        setUser(response.data);
      }
    } catch (err) {
      console.error('Error fetching user profile:', err);
      setError('Failed to fetch user profile.');
    }
  };

  if (error) {
    return <p className="error">{error}</p>;
  }

  if (!user) {
    return <p>Loading...</p>;
  }

  return (
    <div className="user-profile-container">
      <h1>User Profile</h1>
      <div className="user-profile-details">
        <p><strong>User ID:</strong> {user.userId}</p>
        <p><strong>First Name:</strong> {user.firstName}</p>
        <p><strong>Last Name:</strong> {user.lastName}</p>
        <p><strong>Email:</strong> {user.email}</p>
        {user.roles && <p><strong>Roles:</strong> {user.roles.join(', ')}</p>}
        {user.permissions && <p><strong>Permissions:</strong> {user.permissions.join(', ')}</p>}
      </div>
      <Link to="/users" className="back-button">Back to Users</Link>
    </div>
  );
}

// UserResponseModel TypeScript Interface
interface UserResponseModel {
  userId: string;
  firstName: string;
  lastName: string;
  email: string;
  roles?: string[];
  permissions?: string[];
}
