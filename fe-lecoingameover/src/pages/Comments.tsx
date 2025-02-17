import React, { useEffect, useState, useContext } from "react";
import { AuthContext } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import "./Comments.css";

const API_URL = "http://localhost:8080/api/v1/comments";

interface Comment {
    commentId: string;
    name: string;
    message: string;
    timestamp: string;
    approved: boolean;
}

const AdminComments: React.FC = () => {
    const [comments, setComments] = useState<Comment[]>([]);
    const auth = useContext(AuthContext);
    const navigate = useNavigate();

    useEffect(() => {
        if (!auth?.user || auth.user.role !== "admin") {
            navigate("/");
        } else {
            fetch(API_URL)
                .then((res) => res.json())
                .then((data) => setComments(data))
                .catch((err) => console.error("Error fetching comments:", err));
        }
    }, [auth, navigate]);

    const handleDelete = async (commentId: string) => {
        console.log("Attempting to delete comment with ID:", commentId);

        if (!window.confirm("Are you sure you want to delete this comment?")) return;

        try {
            const response = await fetch(`${API_URL}/${commentId}`, {
                method: "DELETE",
                headers: { "Content-Type": "application/json" },
            });

            if (response.ok) {
                console.log("✅ Comment deleted successfully:", commentId);
                setComments((prevComments) => prevComments.filter((comment) => comment.commentId !== commentId));
            } else {
                console.error("❌ Failed to delete comment. Response status:", response.status);
                const errorText = await response.text();
                console.error("Server response:", errorText);
            }
        } catch (error) {
            console.error("❌ Error deleting comment:", error);
        }
    };

    // 🔹 Handle Comment Approval
    const handleApprove = async (commentId: string) => {
        console.log("Approving comment with ID:", commentId);

        try {
            const response = await fetch(`${API_URL}/${commentId}/approve`, {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
            });

            if (response.ok) {
                console.log("✅ Comment approved successfully:", commentId);
                setComments((prevComments) =>
                    prevComments.map((comment) =>
                        comment.commentId === commentId ? { ...comment, approved: true } : comment
                    )
                );
            } else {
                console.error("❌ Failed to approve comment. Response status:", response.status);
                const errorText = await response.text();
                console.error("Server response:", errorText);
            }
        } catch (error) {
            console.error("❌ Error approving comment:", error);
        }
    };

    return (
        <div className="admin-comments-container">
            <h2>Manage Comments</h2>
            <table className="comments-table">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Message</th>
                    <th>Timestamp</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {comments.map((comment) => (
                    <tr key={comment.commentId}>
                        <td>{comment.name}</td>
                        <td>{comment.message}</td>
                        <td>{new Date(comment.timestamp).toLocaleString()}</td>
                        <td>
                            {!comment.approved && (
                                <button className="approve-btn" onClick={() => handleApprove(comment.commentId)}>
                                    Approve
                                </button>
                            )}
                            <button className="delete-btn" onClick={() => handleDelete(comment.commentId)}>
                                Delete
                            </button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default AdminComments;
