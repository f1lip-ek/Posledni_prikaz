package game.dialog;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class Dialog {

    private ArrayList textyDoKonzole;
    private int aktualniIndex = 0;

    public Dialog(){
        nacistList();
    }

    private void nacistList(){
        Gson gson = new Gson();
        try (Reader reader = new FileReader("resources/vypisyDoKonzole.json")) {
            textyDoKonzole = gson.fromJson(reader, ArrayList.class);
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }

    public String getDialog(int cislo, String text){
        return textyDoKonzole.get(cislo) + "\n";
    }

}
