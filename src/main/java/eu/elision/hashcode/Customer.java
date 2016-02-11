package eu.elision.hashcode;

public class Customer {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int costTo(Warehouse warehouse) {
        return DistanceUtil.cost(x, y, warehouse.getX(), warehouse.getY());
    }
}
