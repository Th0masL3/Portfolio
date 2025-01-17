package com.lecoingameover.belecoingameover.paypal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void testOrderGettersAndSetters() {
        Order order = new Order();
        order.setOrderId("test-order-id");
        order.setAmount(99.99);

        assertEquals("test-order-id", order.getOrderId());
        assertEquals(99.99, order.getAmount());
    }

    @Test
    void testOrderSetters() {
        Order order = new Order();
        order.setOrderId("new-order-id");
        order.setAmount(199.99);

        assertEquals("new-order-id", order.getOrderId());
        assertEquals(199.99, order.getAmount());
    }
}
