package game.command;

import game.dialog.Dialog;
import game.itemy.Item;
import game.postavy.Entita;

import java.util.ArrayList;

/**
 * Trida pro command ktery na konci hry ukoncuje hru
 */
public class Konec implements Command{

    private int cislo;
    private final Entita hrac;
    private final Dialog dialogy;
    private final ArrayList<Item> itemy;
    private boolean konec = true;

    public Konec(int cislo, Entita hrac, Dialog dialogy, ArrayList<Item> itemy) {
        this.cislo = cislo;
        this.hrac = hrac;
        this.dialogy = dialogy;
        this.itemy = itemy;
    }

    /**
     * Metoda ktera je se sputi na uplnem konci hry
     * @param text nepouzivany
     * @return text kter hrace utvrdi v tom ze hra skoncila
     */
    @Override
    public String execute(String text) {
        if (cislo == 1 && hrac.getAktualniLokace().getId().equals("terminal")){
            /*start*/
            if (hrac.getInventar().contains(getItem("usb"))){
                konec = true;
                return dialogy.getDialog(29, "");
            }else{
                konec = false;
                return "Nemas usb";
            }
        }else if (cislo == 2 && hrac.getAktualniLokace().getId().equals("terminal") && hrac.getInventar().contains(getItem("usb"))) {
            /*upload*/
            konec = true;
            return dialogy.getDialog(30, "");
        } else {
            return "Nemuzes pouzit protoze nejsi ve spravne mistnosti";
        }
    }

    @Override
    public boolean exit() {
        return konec;
    }

    /**
     * Metoda ktera z id itemu udela objekt Item
     * @param text id itemu
     * @return objekt Itemu
     */
    public Item getItem(String text){
        for (int i = 0; i < itemy.size(); i++) {
            if (itemy.get(i).getId().equals(text)){
                return itemy.get(i);
            }
        }
        return null;
    }
}
