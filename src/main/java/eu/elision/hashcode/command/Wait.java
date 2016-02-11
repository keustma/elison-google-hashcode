package eu.elision.hashcode.command;

import eu.elision.hashcode.Drone;

public class Wait {

    private final Drone drone;
    private final int turns;

    public Wait(Drone drone, int turns) {
        this.drone = drone;
        this.turns = turns;
    }

    public String output() {
        return String.format("%s W %s", drone.getId(), turns);
    }
}
