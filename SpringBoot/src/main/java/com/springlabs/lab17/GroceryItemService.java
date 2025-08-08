package com.springlabs.lab17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {

    @Autowired
    private GroceryItemRepository repository;

    public GroceryItem saveItem(GroceryItem item) {
        return repository.save(item);
    }

    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    public Optional<GroceryItem> getItemById(Long id) {
        return repository.findById(id);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    public GroceryItem updateItem(Long id, GroceryItem updatedItem) {
        return repository.findById(id).map(item -> {
            item.setName(updatedItem.getName());
            item.setQuantity(updatedItem.getQuantity());
            item.setPrice(updatedItem.getPrice());
            return repository.save(item);
        }).orElseGet(() -> {
            updatedItem.setId(id);
            return repository.save(updatedItem);
        });
    }
}