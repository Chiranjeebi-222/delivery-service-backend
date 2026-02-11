package com.deliveryservice.backend;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Added to match your SQL UNIQUE NOT NULL constraint
    @Column(name = "firebase_uid", unique = true, nullable = false)
    private String firebaseUid;

    private String name;
    private String email;
    private String phone;

    // Added to handle different app users (Customer vs Store Owner)
    @Column(name = "primary_role")
    private String primaryRole = "USER"; 

    // IMPORTANT: You need Setters to allow Spring to "Write" data from the POST request
    public void setId(Integer id) { this.id = id; }
    public void setFirebaseUid(String firebaseUid) { this.firebaseUid = firebaseUid; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setPrimaryRole(String primaryRole) { this.primaryRole = primaryRole; }

    // Getters
    public Integer getId() { return id; }
    public String getFirebaseUid() { return firebaseUid; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPrimaryRole() { return primaryRole; }
}