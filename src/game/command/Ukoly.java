package game.command;

import com.google.gson.Gson;
import game.postavy.Entita;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

public class Ukoly implements Command{

    private Entita hrac;

    public Ukoly(Entita hrac) {
        this.hrac = hrac;
    }

    public Ukoly(){}

    @Override
    public String execute(String text) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("resources/ukoly.json")) {
            String[] pomoc = gson.fromJson(reader, String[].class);
            for (int i = 0; i < hrac.getCisloUkolu(); i++) {
                pomoc[i] = getSpravnyRadek(pomoc[i]);
            }
            return Arrays.toString(pomoc);
        }catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }

    @Override
    public boolean exit() {
        return false;
    }

    public String getSpravnyRadek(String text){
        return "\u001B[34m" + text + "\u001B[0m";
    }
}