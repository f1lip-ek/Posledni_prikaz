package game.command;

import game.dialog.Dialog;
import game.itemy.Item;
import game.lokace.Lokace;
import game.postavy.Entita;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VezmiPredmetTest {

    VezmiPredmet v;
    Entita hrac;
    ArrayList<Item> itemy;
    ArrayList<Lokace> lokace;
    Dialog d;
    Item i;
    Lokace l;


    @BeforeEach
    void setUp(){
        hrac = new Entita("");
        itemy = new ArrayList<>();
        lokace = new ArrayList<>();
        d = new Dialog();
        l = new Lokace("byt", new ArrayList<>());
        i = new Item("pistole", "Pistole");
        l.getItems().add("pistole");

        itemy.add(i);
        lokace.add(l);
        hrac.setIdLokace("byt");

        hrac.setIdAktualniLokace(lokace);
        l.setItemyVLokaci(itemy);
        hrac.setInventar(itemy);

        v = new VezmiPredmet(1, hrac, itemy, d);
    }

    @Test
    void execute() {

        v.execute(i.getId());

        assertEquals(1, hrac.getInventar().size());

    }
}