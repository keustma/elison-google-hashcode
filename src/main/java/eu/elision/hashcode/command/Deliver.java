package eu.elision.hashcode.command;

import eu.elision.hashcode.Drone;
import eu.elision.hashcode.Order;
import eu.elision.hashcode.Product;
import eu.elision.hashcode.Warehouse;

public class Deliver implements Command {

    private final Drone drone;
    private final Order order;
    private final Product product;
    private final int amountProducts;

    public Deliver(Drone drone, Order order, Product product, int amountProducts) {
        this.drone = drone;
        this.order = order;
        this.product = product;
        this.amountProducts = amountProducts;
    }

    @Override
    public String output() {
        int droneId = drone.getId();
        int orderId = order.getId();
        int productId = product.getId();

        return String.format("%s D %s %s %s", droneId, orderId, productId, amountProducts);
    }

    @Override
    public void execute() throws Exception {
        // turns van drone - (steps + 1 van load)
        int cost = drone.costTo(order) + 1;
        drone.decreaseTurns(cost);
        drone.setX(order.getX());
        drone.setY(order.getY());
    }


}
