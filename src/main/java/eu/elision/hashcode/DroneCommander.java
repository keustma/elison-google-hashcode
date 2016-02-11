package eu.elision.hashcode;

import java.util.ArrayList;
import java.util.List;

public class DroneCommander {

    private static List<Drone> drones = new ArrayList<>();

    public static void initDrones(int numOfDrones, int turns, int maxLoad) {

        for(int i = 0; i < numOfDrones; i++) {
            drones.add(new Drone(turns, maxLoad));
        }
    }

    public static void command(int drone, Command command, int warehouse, int productType, int numProducts) {

    }
}
