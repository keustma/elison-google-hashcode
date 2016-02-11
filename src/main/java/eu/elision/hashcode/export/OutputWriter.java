package eu.elision.hashcode.export;

import eu.elision.hashcode.Drone;
import eu.elision.hashcode.command.Command;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class OutputWriter {

    public static void writeFile(Collection<Drone> drones) throws IOException {
        File file = new File("googlehashcode.out");

        try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
            int sum = drones.stream().mapToInt(d -> d.getCommands().size()).sum();
            out.println(sum);
            
            for (Drone drone : drones) {
                for (Command comm : drone.getCommands()) {
                    out.println(comm.output());
                }
            }
        }
    }
}
