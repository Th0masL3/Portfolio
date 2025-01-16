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
    // Fetch cart data on component mount
    const fetchCartItems = async () => {
      try {
        const response = await fetch('http://localhost:8080/api/v1/cart/1');
        const data = await response.json();
        setCartItems(data.items); // Assuming the API returns { items: [ ... ] }
      } catch (error) {
        console.error('Error fetching cart items:', error);
      }
    };

    fetchCartItems();
  }, []);

  const calculateSubtotal = (): number => {
    return cartItems.reduce((total, item) => total + item.price, 0);
  };

  const removeCartItem = async (cartItemId: string) => {
    try {
      // Make DELETE request to remove the item
      const response = await fetch(`http://localhost:8080/api/v1/cart/${cartItemId}`, {
        method: 'DELETE',
      });

      if (response.status === 204) {
        // Remove the item from the state
        setCartItems((prevItems) => prevItems.filter((item) => item.cartItemId !== cartItemId));
      } else {
        console.error('Failed to remove item from cart:', response.status);
      }
    } catch (error) {
      console.error('Error removing item from cart:', error);
    }
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
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {cartItems.map((item) => (
            <tr key={item.cartItemId}>
              <td>{item.name}</td>
              <td>{item.description}</td>
              <td>${item.price.toFixed(2)}</td>
              <td>
                <button
                  className="remove-button"
                  onClick={() => removeCartItem(item.cartItemId)}
                >
                  Remove Item from Cart
                </button>
              </td>
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
