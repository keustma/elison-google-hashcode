package eu.elision.hashcode;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int x;
    private int y;

    private List<Product> products = new ArrayList<Product>();
    private int id;

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int costTo(Warehouse warehouse) {
        return DistanceUtil.cost(x, y, warehouse.getX(), warehouse.getY());
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public boolean needsProduct(Product product) {
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
