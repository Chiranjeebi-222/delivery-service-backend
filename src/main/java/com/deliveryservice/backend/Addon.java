package com.deliveryservice.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "addonitem")
public class Addon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer itemid;
    private String addonitemname;
    private Boolean addonitemisveg;
    private Double addonitemprice;
    private String addonitemserving;

    public Addon() {}
    public Integer getId() { return id; }
    public Integer getItemid() { return itemid; }
    public String getAddonitemname() { return addonitemname; }
    public Boolean getAddonitemisveg() { return addonitemisveg; }
    public Double getAddonitemprice() { return addonitemprice; }
    public String getAddonitemserving() { return addonitemserving; }
}