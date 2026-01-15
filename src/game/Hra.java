package game;

import game.command.Command;
import game.lokace.Lokace;
import game.postavy.Entita;
import game.postavy.Hrac;

import java.util.HashMap;
import java.util.Scanner;

public class Hra {

    private boolean konecHry = false;
    private Hrac hrac;
    private HashMap<String, Lokace> herniMapa;
    private HashMap<String, Command> prikazy;
    private Entita[] postavy;
    private Scanner sc = new Scanner(System.in);



    private void inicializace(){

    }

    private void zpracujPrikaz(){

    }

    public void start(){

    }

}
