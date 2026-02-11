package com.deliveryservice.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderDetailsResponse getFullOrderDetails(Integer id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order ID " + id + " not found"));

        // 1. Map Amounts safely (using .doubleValue() with null checks)
        // If a value is null in the DB, it defaults to 0.0 to prevent crashing
        OrderDetailsResponse.Amounts amounts = new OrderDetailsResponse.Amounts(
                order.getSubtotal() != null ? order.getSubtotal() : 0.0, 
                order.getDeliveryFee() != null ? order.getDeliveryFee() : 0.0, 
                order.getTax() != null ? order.getTax() : 0.0, 
                order.getTotalAmount() != null ? order.getTotalAmount() : 0.0
        );

        // 2. Map OrderInfo
        OrderDetailsResponse.OrderInfo orderInfo = new OrderDetailsResponse.OrderInfo(
                order.getId(),
                order.getOrderNumber(),
                order.getStatus(),
                order.getCreatedAt(),
                amounts,
                new OrderDetailsResponse.OrderInfo.PaymentInfo(order.getPaymentMode(), "COMPLETED", "TXN_123")
        );

        // 3. Map Restaurant with NULL CHECK
        OrderDetailsResponse.RestaurantInfo restaurant = null;
        if (order.getStore() != null) {
            restaurant = new OrderDetailsResponse.RestaurantInfo(
                order.getStore().getId(), 
                order.getStore().getName(), 
                "Gunupur", 19.08, 83.81, 
                order.getStore().getFssaiNumber(), 4.5);
        }

        // 4. Map Customer with NULL CHECK
        OrderDetailsResponse.CustomerInfo customer = null;
        if (order.getUser() != null) {
            customer = new OrderDetailsResponse.CustomerInfo(
                order.getUser().getId(), 
                order.getUser().getName(), 
                order.getUser().getPhone(), 
                order.getUser().getEmail(), 
                null);
        }

        // 5. Map Items safely
        // We use doubleValue() because itemPrice is a BigDecimal
        var items = (order.getItems() != null) ? order.getItems().stream()
                .map(item -> new OrderDetailsResponse.ItemInfo(
                        item.getItemName(), 
                        item.getItemPrice() != null ? item.getItemPrice().doubleValue() : 0.0, 
                        item.getQuantity() != null ? item.getQuantity() : 0, 
                        true))
                .collect(Collectors.toList()) : new ArrayList<OrderDetailsResponse.ItemInfo>();

        return new OrderDetailsResponse(orderInfo, customer, restaurant, items, null, new ArrayList<>());
    }
}