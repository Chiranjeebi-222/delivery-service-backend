package com.deliveryservice.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer sid;
    private Boolean isVeg;
    private String itemname;
    private String itembadges;
    private Double itemprice;
    private String itemdesc;
    private String itemserving;
    private String itemiurl;

    public Item() {}
    public Integer getId() { return id; }
    public Integer getSid() { return sid; }
    public Boolean getIsVeg() { return isVeg; }
    public String getItemname() { return itemname; }
    public String getItembadges() { return itembadges; }
    public Double getItemprice() { return itemprice; }
    public String getItemdesc() { return itemdesc; }
    public String getItemserving() { return itemserving; }
    public String getItemiurl() { return itemiurl; }
}