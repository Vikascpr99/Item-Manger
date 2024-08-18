package com.itemmanager.ItemManager.ItemConverter;

import com.itemmanager.ItemManager.Entity.ItemEntity;
import com.itemmanager.ItemManager.ItemDto.ItemDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {
    public ItemDto convertEntity2Dto(ItemEntity ie){
        ItemDto itemDTO = new ItemDto();
        BeanUtils.copyProperties(ie, itemDTO);
        itemDTO.set_id(ie.getId());
        return itemDTO;
    }
}
