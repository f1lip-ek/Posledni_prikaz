package game.command;

public class Ukoly implements Command{

    @Override
    public String execute(String text) {
        return "ukoly";
    }

    @Override
    public boolean exit() {
        return false;
    }
}