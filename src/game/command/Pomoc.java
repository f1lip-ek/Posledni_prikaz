package game.command;

import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
        try (InputStream input = Pomoc.class.getResourceAsStream("/pomoc.json")) {
            if(input == null){
                throw new RuntimeException("Chyba při načítání JSON");
            }
            String[] pomoc = gson.fromJson(new InputStreamReader(input, StandardCharsets.UTF_8), String[].class);
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
