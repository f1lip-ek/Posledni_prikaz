package game.command;

import game.dialog.Dialog;
import game.itemy.Item;
import game.lokace.Lokace;
import game.postavy.Entita;

import java.util.ArrayList;

public class PouzijPredmet implements Command{

    private int cislo;
    private Entita hrac;
    private ArrayList<Item> itemy;
    private Dialog dialogy;
    private ArrayList<Lokace> lokace;


    public PouzijPredmet(int cislo, Entita hrac, ArrayList<Item> itemy, Dialog dialogy, ArrayList<Lokace> lokace) {
        this.cislo = cislo;
        this.hrac = hrac;
        this.itemy = itemy;
        this.dialogy = dialogy;
        this.lokace = lokace;
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
                            yield getItem(text).getPopis();
                        }else {
                            yield "Nejsi na spravnem miste kde se to muze pouzit";
                        }
                    }else {
                        yield "Nemas takovy predmet";
                    }
                }
                case "usb" -> {
                    if (hrac.getInventar().contains(getItem(text)) && hrac.getAktualniLokace().getId().equals("terminal")){
                        if (hrac.isKontrolaServeru() && hrac.isVymazaneChyby()) {
                            yield "Zadej \u001B[31m start\u001B[0m nebo\u001B[31m upload\u001B[0m ";
                        }else {
                            yield "Musis jeste neco udelat";
                        }
                    }
                    yield "Nejsi na spravnem miste kde se to muze pouzit";
                }
                case "pistole", "kamen" -> "Co bys jako chtel udelat?\nZastrelit sam sebe nebo se prastit kamenem do hlavy?";
                case "server" -> {
                    if (hrac.getAktualniLokace().getId().equals("serverovna")){
                        hrac.setKontrolaServeru(true);
                        yield hrac.getAktualniLokace().getItemyVLokaci().getFirst().getPopis();
                    } else {
                        yield "Nejde pouzit. Nejsi ve spravne mistnosti.";
                    }
                }
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