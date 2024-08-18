package com.itemmanager.ItemManager.repository;

import com.itemmanager.ItemManager.Entity.ItemEntity;
import com.itemmanager.ItemManager.ItemDto.ItemDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    List<ItemEntity> findAllByTitleContains(String title);
}
