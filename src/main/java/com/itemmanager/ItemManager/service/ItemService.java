package com.itemmanager.ItemManager.service;

import com.itemmanager.ItemManager.ItemDto.ItemDto;

import java.util.List;

public interface ItemService {

    ItemDto addItem(ItemDto itemDto);

    List<ItemDto> allItems();

    List<ItemDto> searchItemByTitle(String title);

    ItemDto getDetails(Long id);

    ItemDto updateItem(Long id, ItemDto itemDto);

    ItemDto updateItemTitle(Long id, String title);

    void deleteItem(Long id);



}
