package eu.elision.hashcode.command;

public interface Command {
    String output();

    void execute() throws Exception;
}
