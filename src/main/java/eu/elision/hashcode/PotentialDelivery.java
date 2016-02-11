package eu.elision.hashcode;

public class PotentialDelivery {

    private int cost;
    private Order order;
    private Warehouse warehouse;
    private Product product;

    public PotentialDelivery(final int cost, final Order order, final Warehouse warehouse, Product product) {
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

    public Product getProduct() {
        return this.product;
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
