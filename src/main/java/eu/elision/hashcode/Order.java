package eu.elision.hashcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.valueOf;

public class Order {

    private int x;
    private int y;

    private Product[] products = new Product[DatasetUtil.getTotalAmountProducts()];
    private int id;

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addProduct(Product product) {
        products[product.getId()] = product;
    }

    public int costTo(Warehouse warehouse) {
        return DistanceUtil.cost(x, y, warehouse.getX(), warehouse.getY());
    }

    public List<Product> getProducts() {
        return Arrays.asList(products);
    }

    public boolean needsProduct(Product product) {
        return products[product.getId()].getAmount() != 0;
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

    public int getAmountNeeded(Product product) {
        return products[product.getId()].getAmount();
    }
}
