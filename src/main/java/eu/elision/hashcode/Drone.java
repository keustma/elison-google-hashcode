package eu.elision.hashcode;

import java.util.HashMap;
import java.util.Map;

public class Drone {

    private int currentWeight;

    private Map<Product, Integer> loadedProducts = new HashMap<Product, Integer>();

    private int positionX;
    private int positionY;

    public void load(Product product, int amount) {
        if (currentWeight + amount * product.getWeight() > DatasetUtil.getMaximumDroneWeight()) {
            throw new IllegalArgumentException();
        }

        Integer currentAmount = this.loadedProducts.get(product);
        this.loadedProducts.put(product, currentAmount + amount);
    }

    public void unload(Product product, int amount) {
        Integer currentAmount = this.loadedProducts.get(product);

        if (currentAmount > amount) {
            throw new IllegalArgumentException();
        }

        this.loadedProducts.put(product, currentAmount - amount);
    }


    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
