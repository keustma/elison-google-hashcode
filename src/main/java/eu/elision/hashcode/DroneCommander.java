package eu.elision.hashcode;

import eu.elision.hashcode.command.Command;

import java.util.ArrayList;
import java.util.List;

public class DroneCommander {

    private static List<Drone> drones = new ArrayList<Drone>();

    public static void initDrones(int numOfDrones, int turns, int maxLoad) {

        for(int i = 0; i < numOfDrones; i++) {
            drones.add(new Drone(i, turns));
        }
    }

    public static void command(int drone, Command command, int warehouse, int productType, int numProducts) {

    }

    public static List<Drone> getDrones() {
        return drones;
    }
}
