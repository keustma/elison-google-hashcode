package eu.elision.hashcode.command;

import eu.elision.hashcode.Drone;
import eu.elision.hashcode.Product;
import eu.elision.hashcode.Warehouse;

public class Load implements Command {

    private final Drone drone;
    private final Warehouse warehouse;
    private final Product product;
    private final int amountProducts;

    public Load(Drone drone, Warehouse warehouse, Product product, int amountProducts) {
        this.drone = drone;
        this.warehouse = warehouse;
        this.product = product;
        this.amountProducts = amountProducts;
    }

    @Override
    public String output() {
        int droneId = drone.getId();
        int warehouseId = warehouse.getId();
        int productId = product.getId();

        return String.format("%s L %s %s %s", droneId, warehouseId, productId, amountProducts);
    }

    @Override
    public void execute() throws Exception {
        // turns van drone - (steps + 1 van load)
        int cost = drone.costTo(warehouse) + 1;
        drone.decreaseTurns(cost);
        drone.setX(warehouse.getX());
        drone.setY(warehouse.getY());
        warehouse.remove(product, amountProducts);
        drone.load(product, amountProducts);
    }

}
