package org.project.kiosk.order.application;

import org.project.kiosk.order.domain.Order;
import org.project.kiosk.order.storage.OrderStorage;

public class OrderService {
    private final OrderStorage orderStorage;

    public OrderService(OrderStorage orderStorage) {
        this.orderStorage = orderStorage;
    }

    public void save(Order order) {
        orderStorage.save(order);
    }

    public void findByMemberId(String memberId){

    }

}
