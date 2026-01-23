package game.command;

import java.util.Scanner;

/**
 * Trida pro command ktery ukoncuje hru
 */
public class Quit implements Command{

    private boolean ukonceno = false;

    /**
     * Command ktery ukonci celou hru
     * @param text nic nedela
     * @return text ktery presvedci uzivatele ze se hra ukoncila
     */
    @Override
    public String execute(String text) {
        System.out.println("Chcete opravdu ukoncit hru? Prijdete o veskery postup.\ny/n");
        switch (new Scanner(System.in).next()){
            case "y" -> {
                ukonceno = true;
                return "Hra se ukoncuje.";
            }
            case "n" -> {
                ukonceno = false;
                return "Hra se neukoncuje.";
            }
            default -> {
                return "Neznama volba";
            }
        }
    }

    @Override
    public boolean exit() {
        return ukonceno;
    }
}
