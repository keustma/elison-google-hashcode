package eu.elision.hashcode;

import eu.elision.hashcode.command.Deliver;
import eu.elision.hashcode.command.Load;
import eu.elision.hashcode.command.Unload;
import eu.elision.hashcode.export.OutputWriter;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        DatasetUtil.readFile();

        PriorityQueue<PotentialDelivery> queue = new PriorityQueue<PotentialDelivery>(400, (pd1, pd2) -> Integer.compare(pd1.getCost(), pd2.getCost()));

        for(Order order : OrderUtil.getOrders()) {
            for(Product product : order.getProducts()) {
                for(Warehouse warehouse : WarehouseUtil.warehouses) {
                    if(product != null && warehouse.hasProduct(product)) {
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
            int amountNeeded = potentialDelivery.getOrder().getAmountNeeded(potentialDelivery.getProduct());
            int amountAvailable = potentialDelivery.getWarehouse().getAmountAvailable(potentialDelivery.getProduct());
            int amountWantingToTransport = Math.min(amountNeeded, amountAvailable);

            Drone d = selectDrone(potentialDelivery);

            if(d == null) {
                continue;
            }

            int amountAbleToTransport = d.getAmountAbleToTransport(potentialDelivery.getProduct());

            int amountToTransport = Math.min(amountAbleToTransport, amountWantingToTransport);

            Load load = new Load(d, potentialDelivery.getWarehouse(), potentialDelivery.getProduct(), amountToTransport);
            Deliver deliver = new Deliver(d, potentialDelivery.getOrder(), potentialDelivery.getProduct(), amountAbleToTransport);

            d.addCommand(load);
            d.addCommand(deliver);

        }

        OutputWriter.writeFile(DroneCommander.getDrones());
    }

    public static Drone selectDrone(PotentialDelivery potentialDelivery) {
        Drone nearestDrone = null;
        int lowestCost = Integer.MAX_VALUE;
        for(Drone drone : DroneCommander.getDrones()) {

            int costForDelivery = DistanceUtil.cost(potentialDelivery.getWarehouse().getX(), potentialDelivery.getWarehouse().getY(), potentialDelivery.getOrder().getX(), potentialDelivery.getOrder().getY()) + 1;

            int costToWarehouse = drone.costTo(potentialDelivery.getWarehouse());

            int totalCost = costForDelivery + costToWarehouse;

            if(totalCost < lowestCost && drone.getTurns() >= totalCost) {
                lowestCost = costToWarehouse;
                nearestDrone = drone;
            }
        }
        return nearestDrone;
    }
}
