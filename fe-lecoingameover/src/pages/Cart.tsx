import React, { useState, useEffect } from 'react';
import './Cart.css';


interface CartItem {
  cartItemId: string;
  name: string;
  price: number;
  description: string;
}


const Cart = (): JSX.Element => {
  const [cartItems, setCartItems] = useState<CartItem[]>([]);

  useEffect(() => {
    // Make the API call to fetch cart data
    const fetchCartItems = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/v1/cart/1');
        const data = await response.json();
        setCartItems(data.items); // Assuming the API returns { items: [ ... ] }
      } catch (error) {
        console.error("Error fetching cart items:", error);
      }
    };

    fetchCartItems();
  }, []);

  const calculateSubtotal = (): number => {
    return cartItems.reduce((total, item) => total + item.price, 0);
  };

  return (
    <div className="cart-container">
      <h2>Your Cart</h2>

      {/* Cart Table */}
      <table className="cart-table">
        <thead>
          <tr>
            <th>Item Name</th>
            <th>Description</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {cartItems.map((item) => (
            <tr key={item.cartItemId}>
              <td>{item.name}</td>
              <td>{item.description}</td>
              <td>${item.price.toFixed(2)}</td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Subtotal Section */}
      <div className="subtotal">
        <h3>Subtotal: ${calculateSubtotal().toFixed(2)}</h3>
      </div>
    </div>
  );
};

export default Cart;
