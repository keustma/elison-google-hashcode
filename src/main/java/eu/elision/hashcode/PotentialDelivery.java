package eu.elision.hashcode;

public class PotentialDelivery {

    private int cost;
    private Order order;
    private Warehouse warehouse;

    public PotentialDelivery(final int cost, final Order order, final Warehouse warehouse) {
        this.cost = cost;
        this.order = order;
        this.warehouse = warehouse;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
