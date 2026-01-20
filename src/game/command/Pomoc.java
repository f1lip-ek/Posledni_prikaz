package game.command;

import com.google.gson.Gson;
import game.Main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Pomoc implements Command{

    @Override
    public String execute() {
        String cestaKSouboru = "/pomoc.json";
        Gson gson = new Gson();
        String[] pole;
        try (Reader reader = new FileReader(cestaKSouboru)) {
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + cestaKSouboru + " (zkontrolujte, že soubor je v src/main/resources).");
            }

            pole = gson.fromJson(reader, String[].class);
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
        return Arrays.toString(pole);
    }

    @Override
    public boolean exit() {
        return false;
    }
}
