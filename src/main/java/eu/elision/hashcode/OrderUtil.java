package eu.elision.hashcode;

import java.util.ArrayList;
import java.util.List;

public class OrderUtil {

    private List<Order> orders = new ArrayList<>();

    public void initOrders(int numOfOrders) {

        for(int i = 0; i < numOfOrders; i++) {
            orders.add(new Order());
        }
    }

    public Order getOrder(int orderIndex) {
        return orders.get(orderIndex);
    }
}
