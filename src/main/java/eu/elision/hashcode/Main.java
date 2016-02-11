package eu.elision.hashcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        DatasetUtil.readFile();

        PriorityQueue<PotentialDelivery> queue = new PriorityQueue<PotentialDelivery>(400, new Comparator<PotentialDelivery>() {
            public int compare(PotentialDelivery pd1, PotentialDelivery pd2) {
                return Integer.compare(pd1.getCost(), pd2.getCost());
            }
        });

        for(Order order : OrderUtil.getOrders()) {
            for(Product product : order.getProducts()) {
                for(Warehouse warehouse : WarehouseUtil.warehouses) {
                    if(warehouse.hasProduct(product)) {
                        int cost = order.costTo(warehouse);

                        queue.add(new PotentialDelivery(cost, order, warehouse));
                    }
                }
            }
        }

        // process queue
    }
}
