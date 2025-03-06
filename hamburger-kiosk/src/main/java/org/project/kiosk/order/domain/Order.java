package org.project.kiosk.order.domain;

import java.util.List;

public class Order {
    private String memberId;
    private List<OrderItem> items;
    private int totalPrice;

    private Order(){
    }

    public static Order makeOrder(String memberId, List<OrderItem> items, int totalPrice) {
        Order order = new Order();
        order.memberId = memberId;
        order.items = items;
        order.totalPrice = totalPrice;

        return order;
    }

    public String getMemberId() {
        return memberId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
