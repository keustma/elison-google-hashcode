package eu.elision.hashcode;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int x;
    private int y;

    private List<Integer> products = new ArrayList<>();

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addProduct(int productType) {
        products.add(productType);
    }
}
