import { useAuth0 } from "@auth0/auth0-react";
import React from "react";

const Profile = (): JSX.Element | null => {
  const { user, isAuthenticated, isLoading } = useAuth0();

  if (isLoading) {
    return <div>Loading ...</div>;
  }

  if (!isAuthenticated) {
    return null; // Explicitly return null when the user is not authenticated
  }

  return (
    <div className="profile">
      <img src={user?.picture} alt={`${user?.name}'s profile`} />
      <div className="profile-info">
        <h2>{user?.name}</h2>
        <p>{user?.email}</p>
      </div>
    </div>
  );
};

export default Profile;
