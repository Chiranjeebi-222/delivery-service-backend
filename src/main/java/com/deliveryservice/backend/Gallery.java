package com.deliveryservice.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "sgallery")
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer sid;
    private String iurl;

    public Gallery() {}
    public Integer getId() { return id; }
    public Integer getSid() { return sid; }
    public String getIurl() { return iurl; }
}