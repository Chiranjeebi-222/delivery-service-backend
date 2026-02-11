package com.deliveryservice.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "menu_categories")
public class MenuCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "store_id")
    private Integer storeId;

    private String name;

    // Getters
    public Integer getId() { return id; }
    public String getName() { return name; }
    public Integer getStoreId() { return storeId; }
}