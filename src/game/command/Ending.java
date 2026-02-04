package game.command;

import game.dialog.Dialog;
import game.itemy.Item;
import game.postavy.Entita;

import java.util.ArrayList;

public class Ending implements Command{

    private boolean konec = false;
    private int cislo;
    private final Entita hrac;
    private final Dialog dialogy;
    private final ArrayList<Item> itemy;

    public Ending(int cislo, Entita hrac, Dialog dialogy, ArrayList<Item> itemy) {
        this.cislo = cislo;
        this.hrac = hrac;
        this.dialogy = dialogy;
        this.itemy = itemy;
    }

    @Override
    public String execute(String text) {
        if (cislo == 1 && hrac.getAktualniLokace().getId().equals("terminal")){
            /*start*/
            return "";
        }else if (cislo == 2 && hrac.getAktualniLokace().getId().equals("terminal") && hrac.getInventar().contains(getItem("usb"))) {
            /*upload*/
            return "";
        } else {
            return "Nemuzes pouzit protoze nejsi ve spravne mistnosti";
        }
    }

    @Override
    public boolean exit() {
        return konec;
    }

    public Item getItem(String text){
        for (int i = 0; i < itemy.size(); i++) {
            if (itemy.get(i).getId().equals(text)){
                return itemy.get(i);
            }
        }
        return null;
    }
}
