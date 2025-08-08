package com.springlabs.lab17;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/groceryitems")
public class GroceryItemController {

    @Autowired
    private GroceryItemService service;

    @PostMapping
    public ResponseEntity<GroceryItem> createItem(@Valid @RequestBody GroceryItem item) {
        GroceryItem savedItem = service.saveItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }

    @GetMapping
    public List<GroceryItem> getAllItems() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getItemById(@PathVariable Long id) {
        return service.getItemById(id)
                .map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateItem(@PathVariable Long id, @Valid @RequestBody GroceryItem item) {
        GroceryItem updatedItem = service.updateItem(id, item);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}