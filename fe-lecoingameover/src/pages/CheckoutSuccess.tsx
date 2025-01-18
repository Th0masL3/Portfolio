import React, { useEffect, useState } from "react";
import { useSearchParams, useNavigate } from "react-router-dom";
import "./CheckoutSuccess.css";

const CheckoutSuccess = (): JSX.Element => {
    const [searchParams] = useSearchParams();
    const navigate = useNavigate();
    const [status, setStatus] = useState<string | null>(null);

    useEffect(() => {
        const captureOrder = async () => {
            const orderId = searchParams.get("token"); // Confirm PayPal uses "token" for the order ID

            if (!orderId) {
                setStatus("Error: Order token not found.");
                return;
            }

            try {
                // Send the orderId as a path variable
                const response = await fetch(`http://localhost:8080/api/paypal/capture-order/${orderId}`, {
                    method: "POST",
                });

                // Check the response content type
                const contentType = response.headers.get("content-type");
                if (contentType && contentType.includes("application/json")) {
                    // Parse JSON response
                    const data = await response.json();

                    if (data.status === "COMPLETED") {
                        setStatus("Payment successful! Thank you for your purchase. A receipt has been sent to you by email.");
                    } else {
                        setStatus("Payment failed.");
                    }
                } else {
                    // Handle non-JSON response
                    const text = await response.text();
                    console.error("Non-JSON response:", text);
                    setStatus("An error occurred: " + text);
                }
            } catch (error) {
                console.error("Error capturing order:", error);
                setStatus("An error occurred. Please try again later.");
            }
        };

        captureOrder();
    }, [searchParams]);

    const handleGoBack = () => {
        navigate("/");
    };

    return (
        <div className="order-success-container">
            <h1>Order Status</h1>
            {status ? (
                <p>{status}</p>
            ) : (
                <p>Processing your payment. Please wait...</p>
            )}
            {status && (
                <button onClick={handleGoBack} className="order-success-button">
                    Go Back to Homepage
                </button>
            )}
        </div>
    );
};

export default CheckoutSuccess;
