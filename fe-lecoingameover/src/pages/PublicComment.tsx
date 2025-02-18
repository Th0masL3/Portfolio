import React, { useEffect, useState } from "react";
import "./PublicComment.css";
import { useLanguage } from "../LanguageContext";

const API_URL = "https://portfolio-iofk.onrender.com/api/v1/comments";

interface Comment {
    id: string;
    name: string;
    message: string;
    timestamp: string;
    approved: boolean;
}

const PublicComments: React.FC = () => {
    const { t } = useLanguage();
    const [comments, setComments] = useState<Comment[]>([]);
    const [name, setName] = useState<string>(""); // New Name field
    const [message, setMessage] = useState<string>("");

    useEffect(() => {
        fetch(API_URL)
            .then((res) => res.json())
            .then((data: Comment[]) => setComments(data.filter((comment: Comment) => comment.approved)))
            .catch((err) => console.error("Error fetching comments:", err));
    }, []);

    const handleSubmit = (event: React.FormEvent) => {
        event.preventDefault();

        if (!name.trim() || !message.trim()) {
            alert(t("enterNameAndMessage"));
            return;
        }

        const newComment = {
            name,
            message,
            timestamp: new Date().toISOString(),
            approved: false, // Not approved by default
        };

        fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(newComment),
        })
            .then(() => {
                alert(t("commentUnderReview"));
                setName("");
                setMessage("");
            })
            .catch((err) => console.error("Error submitting comment:", err));
    };

    return (
        <div className="public-comments-container">
            <h2>{t("publicCommentsTitle")}</h2>
            <table className="public-comments-table">
                <thead>
                <tr>
                    <th>{t("nameColumn")}</th>
                    <th>{t("messageColumn")}</th>
                    <th>{t("timestampColumn")}</th>
                </tr>
                </thead>
                <tbody>
                {comments.map((comment) => (
                    <tr key={comment.id}>
                        <td>{comment.name}</td>
                        <td>{comment.message}</td>
                        <td>{new Date(comment.timestamp).toLocaleString()}</td>
                    </tr>
                ))}
                </tbody>
            </table>

            <div className="comment-form">
                <h3>{t("addCommentTitle")}</h3>
                <form onSubmit={handleSubmit} className="comment-form-container">
                    <label htmlFor="comment-name" style={{color: "#16213e"}}>{t("nameColumn")}:</label>
                    <input
                        type="text"
                        id="comment-name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                        required
                        placeholder="Enter your name"
                    />

                    <label htmlFor="comment-message" style={{color: "#16213e"}}>{t("messageColumn")}:</label>
                    <textarea
                        id="comment-message"
                        value={message}
                        onChange={(e) => setMessage(e.target.value)}
                        required
                        placeholder="Write your comment..."
                    />

                    <button type="submit">{t("submitButton")}</button>
                </form>
            </div>
        </div>
    );
};

export default PublicComments;
