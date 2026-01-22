package game;

import com.google.gson.Gson;
import game.itemy.Item;
import game.lokace.Lokace;
import game.postavy.Entita;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 */
public class HraData {

    private ArrayList<Item> items;
    private ArrayList<Entita> postavy;
    private ArrayList<Lokace> lokace;

    /**
     *
     * @param cestaKSouboru
     * @return
     */
    public static HraData loadGameDataFromResources(String cestaKSouboru) {
        Gson gson = new Gson();
        try (InputStream is = Main.class.getResourceAsStream(cestaKSouboru)) {
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + cestaKSouboru + " (zkontrolujte, že soubor je v src/main/resources).");
            }
            return gson.fromJson(new InputStreamReader(is, StandardCharsets.UTF_8), HraData.class);

        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Entita> getPostavy() {
        return postavy;
    }

    public ArrayList<Lokace> getLokace() {
        return lokace;
    }

    public void setLists(){
        for (int i = 0; i < postavy.size(); i++) {
            postavy.get(i).setIdAktualniLokace(lokace);
        }
        for (int i = 0; i < lokace.size(); i++) {
            lokace.get(i).setVychody(lokace);
            lokace.get(i).setItemyVLokaci(items);
        }
    }

    @Override
    public String toString() {
        return "HraData{" +
                "items=" + items +
                ", \npostavy=" + postavy +
                ", \nlokace=" + lokace +
                ", velikosti=" + items.size() + ", " + postavy.size() + ", " + lokace.size() +
                '}';
    }
}
