package game.command;

public interface Command {

    String execute(Object object);

    boolean exit();

}
