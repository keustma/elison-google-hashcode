package eu.elision.hashcode;

import eu.elision.hashcode.command.Load;
import eu.elision.hashcode.command.Unload;

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

                        queue.add(new PotentialDelivery(cost, order, warehouse, product));
                    }
                }
            }
        }

        // process queue
        PotentialDelivery potentialDelivery;
        while((potentialDelivery = queue.poll()) != null) {
            if(! potentialDelivery.getOrder().needsProduct(potentialDelivery.getProduct())) {
                continue;
            }

            if(! potentialDelivery.getWarehouse().hasProduct(potentialDelivery.getProduct())) {
                continue;
            }

            // calculate how many products drone still can carry of product type

            // get max product of type from ware

            // calc min of both

            Drone d = selectDrone();

            Load load = new Load(d, potentialDelivery.getWarehouse(), potentialDelivery.getProduct(), 9999); // TODO 9999 veranderen


            Unload unload = new Unload(d, );

            d.addCommand(load);
            d.addCommand(unload);

        }
    }

    public static Drone selectDrone() {
        return null; // TODO
    }
}
