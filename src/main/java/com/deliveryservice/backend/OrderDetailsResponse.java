package com.deliveryservice.backend;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDetailsResponse(
    OrderInfo order,
    CustomerInfo customer,
    RestaurantInfo restaurant,
    List<ItemInfo> items,
    DeliveryInfo delivery,
    List<StatusHistory> orderTimeline
) {
    public record OrderInfo(Integer id, String orderNumber, String status, LocalDateTime createdAt, Amounts amounts, PaymentInfo payment) {
        public record PaymentInfo(String mode, String status, String transactionRef) {}
    }
    public record Amounts(double subtotal, double deliveryFee, double tax, double total) {}
    public record CustomerInfo(Integer id, String name, String phone, String email, AddressInfo deliveryAddress) {}
    public record AddressInfo(String addressText, double latitude, double longitude) {}
    public record RestaurantInfo(Integer id, String name, String city, double latitude, double longitude, String fssaiNumber, double rating) {}
    public record ItemInfo(String name, double price, int quantity, boolean isVeg) {}
    public record DeliveryInfo(Integer partnerId, String name, String phone, String vehicleType, Location pickupLocation, Location dropLocation) {
        public record Location(double latitude, double longitude) {}
    }
    public record StatusHistory(String status, LocalDateTime time) {}
}