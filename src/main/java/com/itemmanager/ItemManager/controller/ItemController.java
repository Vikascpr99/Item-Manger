package com.itemmanager.ItemManager.controller;

import com.itemmanager.ItemManager.ItemDto.ItemDto;
import com.itemmanager.ItemManager.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/items")
    public ResponseEntity<ItemDto> addItem(@RequestBody ItemDto itemDto){
        itemDto = itemService.addItem(itemDto);
        ResponseEntity<ItemDto> res = ResponseEntity.status(201).body(itemDto);
        return res;
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemDto>> allItems(){
        List<ItemDto> items = itemService.allItems();
        return ResponseEntity.status(200).body(items);
    }

    @GetMapping("/search-items-by-title")
    public ResponseEntity<List<ItemDto>> searchByTitle(@RequestParam String title){
        List<ItemDto> items = itemService.searchItemByTitle(title);
        return ResponseEntity.status(200).body(items);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemDto> getDetails(@PathVariable Long id){
        ItemDto item = itemService.getDetails(id);
        return ResponseEntity.status(200).body(item);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long id, @RequestBody ItemDto itemDto){
        ItemDto item = itemService.updateItem(id, itemDto);
        return ResponseEntity.status(200).body(item);
    }

    @PatchMapping("/items/title/{id}")
    public ResponseEntity<ItemDto> updateItemTitle(@PathVariable Long id, @RequestBody ItemDto itemDto){
        itemDto = itemService.updateItemTitle(id, itemDto.getTitle());
        return ResponseEntity.status(200).body(itemDto);
    }

    @DeleteMapping("/items")
    public ResponseEntity<Void> deleteItem(@RequestParam Long id){
        itemService.deleteItem(id);
        ResponseEntity<Void> re = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return re;
    }

}
