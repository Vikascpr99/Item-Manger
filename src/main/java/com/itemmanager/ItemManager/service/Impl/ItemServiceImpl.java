package com.itemmanager.ItemManager.service.Impl;

import com.itemmanager.ItemManager.Entity.ItemEntity;
import com.itemmanager.ItemManager.ItemConverter.ItemConverter;
import com.itemmanager.ItemManager.ItemDto.ItemDto;
import com.itemmanager.ItemManager.repository.ItemRepository;
import com.itemmanager.ItemManager.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemConverter itemConverter;

//    @Autowired
//    private ModelMapper mapper;

    @Override
    public ItemDto addItem(ItemDto itemDto) {
        ItemEntity itemEntity = new ItemEntity();
        BeanUtils.copyProperties(itemDto,itemEntity);

        itemEntity.setCreatedAt(LocalDateTime.now());
        itemEntity.setUpdatedAt(LocalDateTime.now());

        itemEntity = itemRepository.save(itemEntity);
        BeanUtils.copyProperties(itemEntity,itemDto);
        itemDto.set_id(itemEntity.getId());

        return itemDto;
    }

    @Override
    public List<ItemDto> allItems() {
        List<ItemEntity> itemEntities = itemRepository.findAll();
        List<ItemDto> dtoList = null;
        if(!itemEntities.isEmpty()) {
            ItemDto itemDto = null;
            dtoList = new ArrayList<>();
            for (ItemEntity ie : itemEntities) {
                itemDto = new ItemDto();
                BeanUtils.copyProperties(ie, itemDto);
                itemDto.set_id(ie.getId());
                dtoList.add(itemDto);

            }
        }

        return dtoList;
    }

    @Override
    public List<ItemDto> searchItemByTitle(String title) {
        List<ItemEntity> itemEntities = itemRepository.findAllByTitleContains(title);
        List<ItemDto> dtoList = null;
        if(!itemEntities.isEmpty()) {
            ItemDto itemDto = null;
            dtoList = new ArrayList<>();
            for (ItemEntity ie : itemEntities) {
                dtoList.add(itemConverter.convertEntity2Dto(ie));

            }
        }

        return dtoList;
    }

    @Override
    public ItemDto getDetails(Long id) {
       Optional <ItemEntity> optIe = itemRepository.findById(id);
       ItemDto itemDto = null;
       if (!optIe.isEmpty()){
           itemDto = new ItemDto();
           BeanUtils.copyProperties(optIe.get(), itemDto);
           itemDto.set_id(optIe.get().getId());
       }
        return itemDto;
    }

    @Override
    public ItemDto updateItem(Long id, ItemDto itemDto) {
        Optional <ItemEntity> optIe = itemRepository.findById(id);
        if (optIe.isPresent()){
            ItemEntity ie = optIe.get();
            ie.setTitle(itemDto.getTitle());
            ie.setCategory(itemDto.getCategory());
            ie.setDescription(itemDto.getDescription());
            ie.setUpdatedAt(LocalDateTime.now());
            ie = itemRepository.save(ie);
            itemDto = new ItemDto();
            BeanUtils.copyProperties(ie, itemDto);
            itemDto.set_id(optIe.get().getId());
        }

        return itemDto;
    }

    @Override
    public ItemDto updateItemTitle(Long id, String title) {
        Optional <ItemEntity> optIe = itemRepository.findById(id);
        ItemDto itemDto = null;
        if (optIe.isPresent()){
            ItemEntity ie = optIe.get();
            ie.setTitle(title);
            ie.setUpdatedAt(LocalDateTime.now());
            ie = itemRepository.save(ie);
            itemDto = new ItemDto();
            BeanUtils.copyProperties(ie, itemDto);
            itemDto.set_id(optIe.get().getId());
        }

        return itemDto;
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
