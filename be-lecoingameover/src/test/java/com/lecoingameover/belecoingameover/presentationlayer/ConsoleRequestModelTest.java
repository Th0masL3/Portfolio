package com.lecoingameover.belecoingameover.presentationlayer;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleRequestModelTest {

    @Test
    void testGettersAndSetters() {
        ConsoleRequestModel console = new ConsoleRequestModel();
        console.setConsoleName("Test Console");
        console.setReleaseDate(LocalDate.of(2023, 12, 6));
        console.setPrice(299.99);
        console.setQuantityInStock(500);
        console.setCompany("Test Company");
        console.setImage("Test Image");

        assertEquals("Test Console", console.getConsoleName());
        assertEquals(LocalDate.of(2023, 12, 6), console.getReleaseDate());
        assertEquals(299.99, console.getPrice());
        assertEquals(500, console.getQuantityInStock());
        assertEquals("Test Company", console.getCompany());
        assertEquals("Test Image", console.getImage());
    }

    @Test
    void testEqualsAndHashCode() {
        ConsoleRequestModel console1 = new ConsoleRequestModel("Test Console", LocalDate.of(2023, 12, 6), 299.99, 500, "Test Company", "Test Image");
        ConsoleRequestModel console2 = new ConsoleRequestModel("Test Console", LocalDate.of(2023, 12, 6), 299.99, 500, "Test Company", "Test Image");

        assertEquals(console1, console2);
        assertEquals(console1.hashCode(), console2.hashCode());
    }

    @Test
    void testNotEquals() {
        ConsoleRequestModel console1 = new ConsoleRequestModel("Test Console", LocalDate.of(2023, 12, 6), 299.99, 500, "Test Company", "Test Image");
        ConsoleRequestModel console2 = new ConsoleRequestModel("Different Console", LocalDate.of(2024, 1, 1), 199.99, 300, "Different Company", "Different Image");

        assertNotEquals(console1, console2);
    }

    @Test
    void testToString() {
        ConsoleRequestModel console = new ConsoleRequestModel("Test Console", LocalDate.of(2023, 12, 6), 299.99, 500, "Test Company", "Test Image");
        String expected = "ConsoleRequestModel(consoleName=Test Console, releaseDate=2023-12-06, price=299.99, quantityInStock=500, company=Test Company, image=Test Image)";

        assertEquals(expected, console.toString());
    }

    @Test
    void testDefaultConstructor() {
        ConsoleRequestModel console = new ConsoleRequestModel();
        assertNotNull(console);
    }

    @Test
    void testAllArgsConstructor() {
        ConsoleRequestModel console = new ConsoleRequestModel("Test Console", LocalDate.of(2023, 12, 6), 299.99, 500, "Test Company", "Test Image");

        assertEquals("Test Console", console.getConsoleName());
        assertEquals(LocalDate.of(2023, 12, 6), console.getReleaseDate());
        assertEquals(299.99, console.getPrice());
        assertEquals(500, console.getQuantityInStock());
        assertEquals("Test Company", console.getCompany());
        assertEquals("Test Image", console.getImage());
    }

    @Test
    void testBuilder() {
        ConsoleRequestModel console = ConsoleRequestModel.builder()
                .consoleName("Test Console")
                .releaseDate(LocalDate.of(2023, 12, 6))
                .price(299.99)
                .quantityInStock(500)
                .company("Test Company")
                .image("Test Image")
                .build();

        assertEquals("Test Console", console.getConsoleName());
        assertEquals(LocalDate.of(2023, 12, 6), console.getReleaseDate());
        assertEquals(299.99, console.getPrice());
        assertEquals(500, console.getQuantityInStock());
        assertEquals("Test Company", console.getCompany());
        assertEquals("Test Image", console.getImage());
    }

    @Test
    void testCanEqual() {
        ConsoleRequestModel console1 = new ConsoleRequestModel("Test Console", LocalDate.of(2023, 12, 6), 299.99, 500, "Test Company", "Test Image");
        ConsoleRequestModel console2 = new ConsoleRequestModel("Test Console", LocalDate.of(2023, 12, 6), 299.99, 500, "Test Company", "Test Image");

        assertTrue(console1.canEqual(console2));
    }
}
