package com.itemmanager.ItemManager.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Items")
@Getter
@Setter
@NoArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

//    @Column(nullable = false, length = 255, name = "Item_title")
    private String title;

    private String category;

//    @Column(nullable = false, length = 255, name = "Item_desc")
    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;






}
