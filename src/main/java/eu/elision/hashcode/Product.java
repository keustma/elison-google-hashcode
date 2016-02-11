package eu.elision.hashcode;

public class Product {

    private int numOfProducts;
    private int weight;
    private int id;
    private int amount;

    public Product() {

    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.numOfProducts = amount;
    }

    public int getAmount() {
        return numOfProducts;
    }
}
