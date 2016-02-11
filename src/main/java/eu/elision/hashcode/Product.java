package eu.elision.hashcode;

public class Product {

    private int numOfProducts;
    private int weight;

    public Product(int numOfProds) {
        this.numOfProducts = numOfProds;
    }

    public int getNumOfProducts() {
        return numOfProducts;
    }

    public void setNumOfProducts(int numOfProducts) {
        this.numOfProducts = numOfProducts;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
