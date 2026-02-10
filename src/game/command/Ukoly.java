package game.command;

import com.google.gson.Gson;
import game.postavy.Entita;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

/**
 * Trida pro command ktery vypisuje vsechny ukoly ve hre
 */
public class Ukoly implements Command{

    private Entita hrac;

    public Ukoly(Entita hrac) {
        this.hrac = hrac;
    }


    /**
     * Metoda ktera vypise vsechny ukoly ve hre
     * @param text nic nedela
     * @return text ve kterem jsou vsechny ukoly ve hre
     */
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

    /**
     * Metoda ktera rika jestli command ukoncuje hru nebo ne
     * @return false protoze command neukoncuje hru
     */
    @Override
    public boolean exit() {
        return false;
    }

    /**
     * Metoda ktera obarvi ten ukol ktery je splnen
     * @param text ten ukol ktery je splnen
     * @return obarveny text
     */
    public String getSpravnyRadek(String text){
        return "\u001B[34m" + text + "\u001B[0m";
    }
}