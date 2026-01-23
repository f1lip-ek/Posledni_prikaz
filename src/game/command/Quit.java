package game.command;

/**
 * Trida pro command ktery ukoncuje hru
 */
public class Quit implements Command{

    /**
     * Command ktery ukonci celou hru
     * @param text nic nedela
     * @return text ktery presvedci uzivatele ze se hra ukoncila
     */
    @Override
    public String execute(String text) {
        return "Hra se ukoncuje.";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
