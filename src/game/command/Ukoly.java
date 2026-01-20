package game.command;

public class Ukoly implements Command{

    @Override
    public String execute(Object object) {
        return "ukoly";
    }

    @Override
    public boolean exit() {
        return false;
    }
}