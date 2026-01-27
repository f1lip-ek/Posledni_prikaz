package game.command;

import game.lokace.Lokace;
import game.postavy.Entita;

import java.util.ArrayList;
import java.util.Random;

public class Boj implements Command{

    private int cislo;
    private Entita hrac;
    private Entita protivnik;
    private ArrayList<Lokace> lokace;
    private Random rd;
    private boolean ukonceno = false;

    public Boj(int cislo, Entita hrac, Entita protivnik, ArrayList<Lokace> lokace) {
        this.cislo = cislo;
        this.hrac = hrac;
        this.protivnik = protivnik;
        this.lokace = lokace;
        this.rd = new Random();
    }

    @Override
    public String execute(String text) {
        if (cislo == 1){
            if (hrac.getInventar().stream().anyMatch(item -> item.getId().equals("pistole")) || hrac.getInventar().stream().anyMatch(item -> item.getId().equals("kamen"))){
                vyprazdnitInventarProtivnika();
                return "Porazil jsi: " + protivnik.getJmeno();
            }else {
                hrac.setZivoty(0);
                ukonceno = true;
                return "nemas zadne zbrane, zabil te: " + protivnik.getJmeno();
            }
        } else {
            hrac.setZivoty(0);
            ukonceno = true;
            return "umrel jsi\nzabil te: " + protivnik.getJmeno();
        }
    }

    public void vyprazdnitInventarProtivnika(){
        for (int i = protivnik.getInventar().size() - 1; i >= 0; i--) {
            lokace.get(cisloLokace()).getItemyVLokaci().add(protivnik.getInventar().get(i));
            hrac.getAktualniLokace().getItemyVLokaci().add(protivnik.getInventar().get(i));
            protivnik.getInventar().remove(i);
        }
    }

    private int cisloLokace(){
        for (int i = 0; i < lokace.size(); i++) {
            if (lokace.get(i).getId().equals(hrac.getAktualniLokace().getId())){
                return i;
            }
        }
        return 0;
    }

    @Override
    public boolean exit() {
        return ukonceno;
    }
}