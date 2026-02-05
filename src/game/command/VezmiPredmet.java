package game.command;

import game.dialog.Dialog;
import game.itemy.Item;
import game.postavy.Entita;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Command pro Vzeti predmetu nebo pro vypsani predmetu v lokaci
 */
public class VezmiPredmet implements Command{

    private int cislo;
    private Entita hrac;
    private ArrayList<Item> itemy;
    private Dialog dialogy;

    public VezmiPredmet(int cislo, Entita hrac, ArrayList<Item> itemy, Dialog dialog) {
        this.cislo = cislo;
        this.hrac = hrac;
        this.itemy = itemy;
        this.dialogy = dialog;
    }

    /**
     * Metoda ktera dovoli hraci aby pridal item z lokace do inventare
     * @param text id itemu
     * @return potvrzeni pro hrace ze byl item pridan do inventare
     */
    @Override
    public String execute(String text) {
        if (cislo == 1){
            if (getItem(text) != null && hrac.getAktualniLokace().getItemyVLokaci().contains(getItem(text))) {
                if (!text.equals("server")){
                    if (hrac.getInventar().size() + 1 <= hrac.getMAX_NOSNOST()) {
                        if (!hrac.getInventar().contains(getItem(text))) {
                            hrac.getInventar().add(getItem(text));
                            hrac.getAktualniLokace().getItemyVLokaci().remove(getItem(text));
                            return "Pridano do inventare";
                        } else {
                            return "Uz to mas v inventari";
                        }
                    } else {
                        return "Nemuzes pridat mas plny inventar";
                    }
                }else {
                    return "Nemuzes sebrat server, ale muzes ho pouzit";
                }
            } else if (getItem(text) != null && !hrac.getAktualniLokace().getItemyVLokaci().contains(getItem(text))) {
                return "Item neni v tve aktualni lokaci";
            } else {
                return "Item neexistuje";
            }
        }else {
            if (hrac.getAktualniLokace().getId().equals("lab")){
                hrac.setVymazaneChyby(true);
                return dialogy.getDialog(22, "");
            }
            if (hrac.getAktualniLokace().getId().equals("rozvodna")){
                hrac.setRozhodnutiEl(true);
                System.out.println(dialogy.getDialog(24, ""));
                System.out.println(dialogy.getDialog(27, ""));
                System.out.println("Zadej 1 pokud chces pretizit zbrane stroju");
                if (new Scanner(System.in).nextInt() == 1){
                    hrac.setVolba(1);
                    return dialogy.getDialog(25, "");
                }else{
                    hrac.setVolba(0);
                    return dialogy.getDialog(26, "");
                }
            }
            return "Itemy v lokaci :" + hrac.getAktualniLokace().getItemyVLokaci().toString();
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