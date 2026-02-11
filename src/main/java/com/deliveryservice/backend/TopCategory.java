package com.deliveryservice.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "topcategory")
public class TopCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryid;
    private Integer cityid;
    private String categoryname;
    private String categoryiurl;

    public TopCategory() {}
    public Integer getCategoryid() { return categoryid; }
    public Integer getCityid() { return cityid; }
    public String getCategoryname() { return categoryname; }
    public String getCategoryiurl() { return categoryiurl; }
}