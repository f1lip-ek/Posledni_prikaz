package game.command;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

public class Ukoly implements Command{

    @Override
    public String execute(String text) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("resources/ukoly.json")) {
            String[] pomoc = gson.fromJson(reader, String[].class);
            return Arrays.toString(pomoc);
        }catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}