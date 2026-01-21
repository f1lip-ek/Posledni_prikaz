package game.command;

public interface Command {

    String execute(String text);

    boolean exit();

}
