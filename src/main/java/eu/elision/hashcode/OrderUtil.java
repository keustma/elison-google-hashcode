package eu.elision.hashcode;

import java.util.ArrayList;
import java.util.List;

public class OrderUtil {

    private static List<Order> orders = new ArrayList<Order>();

    public static void initOrders(int numOfOrders) {

        for(int i = 0; i < numOfOrders; i++) {
            orders.add(new Order());
        }
    }

    public static Order getOrder(int orderIndex) {
        return orders.get(orderIndex);
    }

    public static List<Order> getOrders() {
        return orders;
    }
}
