package com.deliveryservice.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    
    @Column(name = "city_id")
    private Integer cityId;
    
    @Column(name = "fssai_number")
    private String fssaiNumber;
    
    private Double rating;
    
    @Column(name = "is_open")
    private Boolean isOpen;
    
    private String status;

    @Column(name = "owner_user_id")
    private Integer ownerUserId;

    // Added to fix the 'no default value' errors
    private Double latitude;
    private Double longitude;
    private String address;

    // 1. Mandatory No-Args Constructor for JPA
    public Store() {}

    // 2. Full Getters (Required for the browser to show JSON)
    public Integer getId() { return id; }
    public String getName() { return name; }
    public Integer getCityId() { return cityId; }
    public String getFssaiNumber() { return fssaiNumber; }
    public Double getRating() { return rating; }
    public Boolean getIsOpen() { return isOpen; }
    public String getStatus() { return status; }
    public Integer getOwnerUserId() { return ownerUserId; }
    public Double getLatitude() { return latitude; }
    public Double getLongitude() { return longitude; }
    public String getAddress() { return address; }

    // 3. Full Setters (Required for Hibernate to fill data from MySQL)
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCityId(Integer cityId) { this.cityId = cityId; }
    public void setFssaiNumber(String fssaiNumber) { this.fssaiNumber = fssaiNumber; }
    public void setRating(Double rating) { this.rating = rating; }
    public void setIsOpen(Boolean isOpen) { this.isOpen = isOpen; }
    public void setStatus(String status) { this.status = status; }
    public void setOwnerUserId(Integer ownerUserId) { this.ownerUserId = ownerUserId; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
    public void setAddress(String address) { this.address = address; }
}