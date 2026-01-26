package game.command;

import game.itemy.Item;
import game.postavy.Entita;

import java.util.ArrayList;

/**
 * Command pro Vzeti predmetu nebo pro vypsani predmetu v lokaci
 */
public class VezmiPredmet implements Command{

    private int cislo;
    private Entita hrac;
    private ArrayList<Item> itemy;

    public VezmiPredmet(int cislo, Entita hrac, ArrayList<Item> itemy) {
        this.cislo = cislo;
        this.hrac = hrac;
        this.itemy = itemy;
    }

    /**
     * Metoda ktera dovoli hraci aby pridal item z lokace do inventare
     * @param text id itemu
     * @return potvrzeni pro hrace ze byl item pridan do inventare
     */
    @Override
    public String execute(String text) {
        if (cislo == 1){
            if (getItem(text) != null) {
                if (hrac.getInventar().size() + 1 <= hrac.getMAX_NOSNOST()) {
                    if (!hrac.getInventar().contains(getItem(text))) {
                        hrac.getInventar().add(getItem(text));
                        return "Pridano do inventare -> " + hrac.getInventar().toString();
                    } else {
                        return "Uz to mas v inventari";
                    }
                } else {
                    return "Nemuzes pridat mas plny inventar";
                }
            }else {
                return "Item neexistuje";
            }
        }else {
            return "Itemy v lokaci" + hrac.getAktualniLokace().getItemyVLokaci().toString();
        }
    }

    @Override
    public boolean exit() {
        return false;
    }

    /**
     * Metoda ktera udela z id itemu item
     * @param text id predmetu
     * @return objekt Itemu
     */
    public Item getItem(String text){
        for (Item item : itemy) {
            if (item.getId().equals(text)) {
                return item;
            }
        }
        return null;
    }
}