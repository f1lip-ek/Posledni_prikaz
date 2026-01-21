package game.command;

public class Quit implements Command{
    @Override
    public String execute(String text) {
        return "Hra se ukoncuje.";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
