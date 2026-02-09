package game.postavy;

import game.itemy.Item;
import game.lokace.Lokace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EntitaTest {

    Entita e;
    ArrayList<Item> itemy;
    ArrayList<Lokace> lokace;
    Item item1;
    Item item2;
    Lokace lokace1;
    Lokace lokace2;


    @BeforeEach
    void setUp() {
        e = new Entita("");
        item1 = new Item("pistole", "Pistole");
        item2 = new Item("kamera", "Sledovaci Zarizeni");
        lokace1 = new Lokace("byt", new ArrayList<>());
        lokace2 = new Lokace("ulice", new ArrayList<>());
        itemy = new ArrayList<>();
        lokace = new ArrayList<>();

        itemy.add(item1);
        itemy.add(item2);

        lokace.add(lokace1);
        lokace.add(lokace2);

    }

    @Test
    void setInventar() {

        e.getIdItemu().add(item1.getId());
        e.getIdItemu().add(item2.getId());

        e.setInventar(itemy);

        assertEquals(itemy, e.getInventar());

    }

    @Test
    void setIdAktualniLokace() {

        e.setIdLokace("byt");

        e.setIdAktualniLokace(lokace);

        assertEquals(lokace1, e.getAktualniLokace());

    }
}