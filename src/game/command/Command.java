package game.command;

/**
 * Defaultni interface pro vsechny commandy
 */
public interface Command {

    String execute(String text);

    boolean exit();

}
