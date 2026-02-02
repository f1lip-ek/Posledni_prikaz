package game.command;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

/**
 * Trida pro command ktery vypisuje vsechny commandy ve hre
 */
public class Pomoc implements Command{
    /**
     * Metoda ktera precte pomoc.json ve kterem jsou napsane vsechny commandy ve hre
     * @param text nic nedela
     * @return textovy retezec ve kterem jsou napsane vsechny commandy ve hre
     */
    @Override
    public String execute(String text) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("resources/pomoc.json")) {
            String[] pomoc = gson.fromJson(reader, String[].class);
            return Arrays.toString(pomoc);
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }

    /**
     * Metoda ktera rika jestli command ukoncuje hru nebo ne
     * @return false protoze command neukoncuje hru
     */
    @Override
    public boolean exit() {
        return false;
    }
}
