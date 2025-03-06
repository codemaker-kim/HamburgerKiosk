package org.project.kiosk.order.storage;

import org.project.kiosk.order.domain.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderStorage {
    private List<Order> orderList;

    public OrderStorage(){
        orderList = new ArrayList<>();
    }

    public void save(Order order){
        orderList.add(order);
    }
}
