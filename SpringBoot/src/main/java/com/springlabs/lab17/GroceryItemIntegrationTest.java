package com.springlabs.lab17;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GroceryItemIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateItemAndGetById() {
        GroceryItem newItem = new GroceryItem();
        newItem.setName("Milk");
        newItem.setQuantity(2);
        newItem.setPrice(3.50);

        ResponseEntity<GroceryItem> response = restTemplate.postForEntity("/api/groceryitems", newItem, GroceryItem.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        Long newId = response.getBody().getId();
        ResponseEntity<GroceryItem> getResponse = restTemplate.getForEntity("/api/groceryitems/{id}", GroceryItem.class, newId);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertEquals("Milk", getResponse.getBody().getName());
    }
}