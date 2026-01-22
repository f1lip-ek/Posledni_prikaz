package game;

import game.command.*;
import game.itemy.Item;
import game.postavy.Entita;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/***
 * Trida ktera obsahuje vsechny herni prvky a ma na starosti commandy
 */
public class Hra {

    private boolean konecHry = false;
    private Entita hrac;
    private HashMap<String, Command> prikazy;
    private Entita[] postavy;
    private Scanner sc;
    private HraData data;
    private ArrayList<Item> itemy;

    /**
     * Metoda ktera inicializuje vsechny vlastnosti tridy Hra
     */
    private void inicializaceVlastnosti(){
        this.sc = new Scanner(System.in);
        this.data = HraData.loadGameDataFromResources("/gamedata.json");
        this.hrac = data.getPostavy().getFirst();
        this.prikazy = new HashMap<>();
        this.postavy = data.getPostavy().toArray(new Entita[0]);
        this.itemy = data.getItems();
    }

    /**
     * Metoda ktera naplni vsechny ArrayListy/pole ve hre
     */
    private void setListy(){
        hrac.setInventar(itemy);
        hrac.setIdAktualniLokace(data.getLokace());
        for (int i = 0; i < data.getLokace().size(); i++) {
            data.getLokace().get(i).setVychody(data.getLokace());
            data.getLokace().get(i).setItemyVLokaci(itemy);
        }
    }

    /**
     * Metoda na vlozeni vsech commandu do HashMapy
     */
    private void inicializaceCommandu(){
        prikazy.put("help", new Pomoc());
        prikazy.put("quit", new Quit());
        prikazy.put("ls -q", new Ukoly());
        prikazy.put("kill", new Boj(1, hrac));
        prikazy.put("exit", new Boj(2, hrac));
        prikazy.put("run", new PouzijPredmet(1, hrac));
        prikazy.put("cat -i", new PouzijPredmet(2, hrac));
        prikazy.put("get", new VezmiPredmet(1, hrac));
        prikazy.put("ls -p", new VezmiPredmet(2, hrac));
        prikazy.put("ls -c", new Pohyb(1, hrac));
        prikazy.put("cd", new Pohyb(2, hrac));
    }

    /**
     * Metoda ktera zpracuje prikaz ktery ji prijde
     */
    private void zpracujPrikaz(){
        System.out.println(hrac.getAktualniLokace());
        System.out.print(">>");
        String prikaz = sc.nextLine();
        String[] pole = prikaz.split(" ");
        pole[0] = pole[0].trim().toLowerCase();
        String[] textovePole = getPrikaz(pole);

        //System.out.println(Arrays.toString(textovePole));

        if (prikazy.containsKey(textovePole[0]) && textovePole.length == 1) {
            System.out.println(">> " + prikazy.get(textovePole[0]).execute(textovePole[0]));
            konecHry = prikazy.get(textovePole[0]).exit();
        } else if (prikazy.containsKey(textovePole[0]) && textovePole.length != 1) {
            for (int i = 2; i < textovePole.length; i++) {
                pole[1] += " " + textovePole[i];
            }
            System.out.println(">> " + prikazy.get(textovePole[0]).execute(textovePole[1]));
            konecHry = prikazy.get(textovePole[0]).exit();
            hrac.setIdAktualniLokace(data.getLokace());
        } else {
            System.out.println(">> Nedefinovany prikaz");
        }
    }

    /**
     * Metoda ktera rozdeli pole textu ktere prislo od hrace do konzole na command + ten zbytek rozdeli po slovech
     * @param pole pole ktere je potreba rozdelit
     * @return upravene pole
     */
    private String[] getPrikaz(String[] pole){
        if (!prikazy.containsKey(pole[0]) && pole.length > 1) {
            String text = pole[0] + " " + pole[1];
            if (prikazy.containsKey(text)){
                pole[0] = text;

                for (int i = 1; i < pole.length; i++) {
                    if (i + 1 < pole.length) {
                        pole[i] = pole[i + 1];
                    } else if (i == pole.length-1) {
                        pole[i] = "";
                    }
                }

                pole = Arrays.copyOf(pole, pole.length-1);
            }
        }
        return pole;
    }

    /**
     * Metoda ktera vse spousti a obsahuje herni smycku
     */
    public void start(){
        inicializaceVlastnosti();
        setListy();
        inicializaceCommandu();
        do {
            zpracujPrikaz();
        }while (!konecHry);
    }

}
