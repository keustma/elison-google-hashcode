package eu.elision.hashcode;

public class Warehouse {

    private Product[] products = new Product[DatasetUtil.getTotalAmountProducts()];

    private int x;
    private int y;
    
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addProducts(int productNr, int numOfProds) {
        products[productNr] = new Product(numOfProds);
    }
}
