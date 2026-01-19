package game;

import game.command.Command;
import game.command.Pomoc;
import game.command.Quit;
import game.itemy.Item;
import game.postavy.Entita;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hra {

    private boolean konecHry = false;
    private Entita hrac;
    private HashMap<String, Command> prikazy;
    private Entita[] postavy;
    private Scanner sc;
    private GameData data;
    private ArrayList<Item> itemy;

    private void inicializaceVlastnosti(){
        this.sc = new Scanner(System.in);
        this.data = GameData.loadGameDataFromResources("/gamedata.json");
        this.hrac = data.getPostavy().getFirst();
        this.prikazy = new HashMap<>();
        this.postavy = data.getPostavy().toArray(new Entita[0]);
        this.itemy = data.getItems();
    }

    public void setListy(){
        hrac.setInventar(itemy);
        hrac.setIdAktualniLokace(data.getLokace());
        for (int i = 0; i < data.getLokace().size(); i++) {
            data.getLokace().get(i).setVychody(data.getLokace());
            data.getLokace().get(i).setItemyVLokaci(itemy);
        }
    }

    private void inicializaceCommandu(){
        prikazy.put("help", new Pomoc());
        prikazy.put("quit", new Quit());
    }

    private void zpracujPrikaz(){
        System.out.print(">>");
        String prikaz = sc.next();
        prikaz = prikaz.trim().toLowerCase();
        if (prikazy.containsKey(prikaz)) {
            System.out.println(">> " + prikazy.get(prikaz).execute());
            konecHry = prikazy.get(prikaz).exit();
        } else {
            System.out.println(">> Nedefinovany prikaz");
        }
    }

    public void start(){
        inicializaceVlastnosti();
        setListy();
        inicializaceCommandu();
        do {
            zpracujPrikaz();
        }while (!konecHry);
    }

}
