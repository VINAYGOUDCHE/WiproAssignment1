package com.springlabs.lab17;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GroceryItemServiceTest {

    @Mock
    private GroceryItemRepository repository;

    @InjectMocks
    private GroceryItemService service;

    @Test
    public void testSaveItem() {
        GroceryItem item = new GroceryItem();
        item.setName("Apple");
        when(repository.save(item)).thenReturn(item);
        GroceryItem savedItem = service.saveItem(item);
        assertEquals("Apple", savedItem.getName());
    }

    @Test
    public void testGetItemById() {
        GroceryItem item = new GroceryItem();
        item.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(item));
        Optional<GroceryItem> foundItem = service.getItemById(1L);
        assertEquals(1L, foundItem.get().getId());
    }
}