package eu.elision.hashcode.command;

import eu.elision.hashcode.Drone;
import eu.elision.hashcode.Product;
import eu.elision.hashcode.Warehouse;

public class Deliver {

    private final Drone drone;
    private final Warehouse warehouse;
    private final Product product;
    private final int amountProducts;

    public Deliver(Drone drone, Warehouse warehouse, Product product, int amountProducts) {
        this.drone = drone;
        this.warehouse = warehouse;
        this.product = product;
        this.amountProducts = amountProducts;
    }

    private String output() {
        int droneId = drone.getId();
        int warehouseId = warehouse.getId();
        int productId = product.getId();

        return String.format("%s D %s %s %s", droneId, warehouseId, productId, amountProducts);
    }
}