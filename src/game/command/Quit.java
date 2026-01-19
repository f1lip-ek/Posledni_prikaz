package game.command;

public class Quit implements Command{
    @Override
    public String execute() {
        return "Program se vypina.";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
