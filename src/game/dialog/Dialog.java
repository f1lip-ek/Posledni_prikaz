package game.dialog;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Trida pro manipulovani s dialogy
 */
public class Dialog {

    private ArrayList textyDoKonzole;

    public Dialog(){
        nacistList();
    }

    /**
     * Metoda ktera nacte vsechny dialogy do ArrayListy
     */
    private void nacistList(){
        Gson gson = new Gson();
        try (InputStream input = Dialog.class.getResourceAsStream("/vypisyDoKonzole.json")) {
            if(input == null){
                throw new RuntimeException("Chyba při načítání JSON");
            }
            textyDoKonzole = gson.fromJson(new InputStreamReader(input, StandardCharsets.UTF_8), ArrayList.class);
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }

    /**
     * Metoda ktera vrati urcity dialog
     * @param cislo cislo dialogu
     * @param text nepouzivan
     * @return dany dialog
     */
    public String getDialog(int cislo, String text){
        return textyDoKonzole.get(cislo) + "\n";
    }

}
