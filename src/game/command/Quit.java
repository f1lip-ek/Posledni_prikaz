package game.command;

public class Quit implements Command{
    @Override
    public String execute(Object object) {
        return "Hra se ukoncuje.";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
