package game.dialog;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.Reader;
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
        try (Reader reader = new FileReader("resources/vypisyDoKonzole.json")) {
            textyDoKonzole = gson.fromJson(reader, ArrayList.class);
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
