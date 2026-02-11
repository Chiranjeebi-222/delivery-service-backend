package com.deliveryservice.backend;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_number")
    private String orderNumber;
    private String status;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // Financial fields
    private Double subtotal;
    @Column(name = "delivery_fee")
    private Double deliveryFee;
    private Double tax;
    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "payment_mode")
    private String paymentMode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Relationship to Customer

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store; // Relationship to Restaurant

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;

    // Getters
    public Integer getId() { return id; }
    public String getOrderNumber() { return orderNumber; }
    public String getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Double getSubtotal() { return subtotal; }
    public Double getDeliveryFee() { return deliveryFee; }
    public Double getTax() { return tax; }
    public Double getTotalAmount() { return totalAmount; }
    public String getPaymentMode() { return paymentMode; }
    public User getUser() { return user; }
    public Store getStore() { return store; }
    public List<OrderItem> getItems() { return items; }
}