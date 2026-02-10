package game.command;

import game.dialog.Dialog;
import game.itemy.Item;
import game.postavy.Entita;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PouzijPredmetTest {

    Entita hrac;
    ArrayList<Item> itemy;
    PouzijPredmet p;


    @BeforeEach
    void setUp(){
        hrac = new Entita("");
        itemy = new ArrayList<>();
        itemy.add(new Item("kamera", "Sledovaci zarizeni"));

        p = new PouzijPredmet(1, hrac, itemy, new Dialog(), new ArrayList<>());
    }

    @Test
    void execute() {
        p.execute("kamera");

        assertEquals(0, hrac.getInventar().size());
    }
}