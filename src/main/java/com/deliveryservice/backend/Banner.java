package com.deliveryservice.backend;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "admin_banners")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "city_id", nullable = false)
    private Integer cityId;

    @Column(name = "image_url", length = 500)
    private String bImage;

    @Column(name = "link_url")
    private String bLink;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    // 1. Mandatory No-Args Constructor for JPA
    public Banner() {}

    // 2. Getters
    public Integer getId() { return id; }
    public Integer getCityId() { return cityId; }
    public String getbImage() { return bImage; }
    public String getbLink() { return bLink; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // 3. Setters (Required for Spring to map JSON/Database data)
    public void setId(Integer id) { this.id = id; }
    public void setCityId(Integer cityId) { this.cityId = cityId; }
    public void setbImage(String bImage) { this.bImage = bImage; }
    public void setbLink(String bLink) { this.bLink = bLink; }
}