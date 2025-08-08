package com.springlabs.lab17;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GroceryItemController.class)
public class GroceryItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateItem() throws Exception {
        GroceryItem item = new GroceryItem();
        item.setName("Bread");
        when(service.saveItem(any(GroceryItem.class))).thenReturn(item);

        mockMvc.perform(post("/api/groceryitems")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(item)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Bread"));
    }

    @Test
    public void testGetItemById() throws Exception {
        GroceryItem item = new GroceryItem();
        item.setId(1L);
        when(service.getItemById(1L)).thenReturn(Optional.of(item));

        mockMvc.perform(get("/api/groceryitems/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }
}