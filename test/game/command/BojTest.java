package game.command;

import game.dialog.Dialog;
import game.itemy.Item;
import game.lokace.Lokace;
import game.postavy.Entita;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BojTest {

    Entita hrac;
    Entita protivnik;
    ArrayList<Lokace> lokace;
    ArrayList<Item> itemy;
    Boj b;

    @BeforeEach
    void setUp() {
        hrac = new Entita("");
        protivnik = new Entita("");
        lokace = new ArrayList<>();
        itemy = new ArrayList<>();

        itemy.add(new Item("pistole", "Pistole"));
        hrac.getIdItemu().add("pistole");
        hrac.setInventar(itemy);
        hrac.setKamera(true);

        b = new Boj(1, hrac, protivnik, lokace, new Dialog());

    }


    @Test
    void execute() {

        b.execute("");

        assertEquals(true, hrac.isPorazenyGolias());

    }
}