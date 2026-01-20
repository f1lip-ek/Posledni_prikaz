package game.command;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;

public class Pomoc implements Command{

    @Override
    public String execute() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("resources/pomoc.json")) {
            String[] pole = gson.fromJson(reader, String[].class);
            return Arrays.toString(pole);
        } catch (FileNotFoundException ex){
            System.err.println(ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
        return null;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
