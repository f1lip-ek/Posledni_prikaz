package game.command;

import game.itemy.Item;
import game.postavy.Entita;

import java.util.ArrayList;

public class VezmiPredmet implements Command{

    private int cislo;
    private Entita hrac;
    private ArrayList<Item> itemy;

    public VezmiPredmet(int cislo, Entita hrac, ArrayList<Item> itemy) {
        this.cislo = cislo;
        this.hrac = hrac;
        this.itemy = itemy;
    }

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

    public Item getItem(String text){
        for (Item item : itemy) {
            if (item.getId().equals(text)) {
                return item;
            }
        }
        return null;
    }
}