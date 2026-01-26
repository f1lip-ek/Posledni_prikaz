package game.command;

import game.itemy.Item;
import game.postavy.Entita;

import java.util.ArrayList;

public class PouzijPredmet implements Command{

    private int cislo;
    private Entita hrac;
    private ArrayList<Item> itemy;

    public PouzijPredmet(int cislo, Entita hrac, ArrayList<Item> itemy) {
        this.cislo = cislo;
        this.hrac = hrac;
        this.itemy = itemy;
    }

    @Override
    public String execute(String text) {
        if (cislo == 1){
            return switch (text){
                case "kamera" -> {
                    if (hrac.getInventar().contains(getItem(text))) {
                        if (hrac.getAktualniLokace().getId().equals("ulice")){
                            hrac.getAktualniLokace().getItemyVLokaci().add(getItem(text));
                            hrac.getInventar().remove(getItem(text));
                            yield hrac.getAktualniLokace().getItemyVLokaci().toString() + "penis";
                        }else {
                            yield "Nejsi na spravnem miste kde se ";
                        }
                    }else {
                        yield "Nemas takovy predmet";
                    }
                }
                case "usb" -> "";
                case "pistole", "kamen" -> "Nejsi v boji.";
                default -> "Nemas takovy predmet";
            };
        }else {
            return "Inventar: " +  hrac.getInventar().toString();
        }
    }

    @Override
    public boolean exit() {
        return false;
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