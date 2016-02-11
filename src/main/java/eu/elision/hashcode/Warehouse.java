package eu.elision.hashcode;

public class Warehouse {

    private Product[] products = new Product[DatasetUtil.getTotalAmountProducts()];

    private int x;
    private int y;
    private int id;

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addProducts(int productNr, int numOfProds) {
        products[productNr] = new Product(numOfProds);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int costTo(Drone drone) {
        return DistanceUtil.cost(x, y, drone.getX(), drone.getY());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean hasProduct(Product product) {
        return products[product.getId()].getNumOfProducts() > 0;
    }

    public int getAmountAvailable(Product product) {
        return products[product.getId()].getAmount();
    }

}
