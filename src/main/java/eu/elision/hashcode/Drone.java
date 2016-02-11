package eu.elision.hashcode;

import eu.elision.hashcode.command.Command;
import eu.elision.hashcode.command.Unload;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drone {

    private int turns;
    private int currentWeight;

    private Map<Product, Integer> loadedProducts = new HashMap<Product, Integer>();

    private int x;
    private int y;
    private int id;
    private List<Command> commands;

    public Drone(int turns) {
        this.turns = turns;
    }

    public void decreaseTurns(int decreaseAmount) throws Exception {
        this.turns -= decreaseAmount;

        if(this.turns < 0) {
            throw new Exception("Negative turns on drone!");
        }
    }

    public void load(Product product, int amount) {
        if (currentWeight + amount * product.getWeight() > DatasetUtil.getMaximumDroneWeight()) {
            throw new IllegalArgumentException();
        }

        Integer currentAmount = this.loadedProducts.get(product);
        this.loadedProducts.put(product, currentAmount + amount);

        this.currentWeight += product.getWeight() * amount;
    }

    public void unload(Product product, int amount) {
        Integer currentAmount = this.loadedProducts.get(product);

        if (currentAmount > amount) {
            throw new IllegalArgumentException();
        }

        this.loadedProducts.put(product, currentAmount - amount);

        this.currentWeight -= product.getWeight() * amount;
    }

    public int costTo(Warehouse warehouse) {
        return DistanceUtil.cost(x, y, warehouse.getX(), warehouse.getY());
    }


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public int getTurns() {
        return turns;
    }

    public int getAmountAbleToTransport(Product product) {
        return (DatasetUtil.getMaximumDroneWeight() - currentWeight) / product.getWeight();
    }

    public int costTo(Order order) {
        return DistanceUtil.cost(x, y, order.getX(), order.getY());
    }
}
