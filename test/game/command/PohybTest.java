package game.command;

import game.itemy.Item;
import game.lokace.Lokace;
import game.postavy.Entita;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PohybTest {

    Entita hrac;
    Lokace lokace1;
    Lokace lokace2;
    ArrayList<Lokace> svet;
    Item item;
    Pohyb pohyb;

    @BeforeEach
    void setUp() {
        hrac = new Entita();
        svet = new ArrayList<>();
        item = new Item();

        svet.add(new Lokace("byt", new ArrayList<>()));
        svet.add(new Lokace("ulice", new ArrayList<>()));
        svet.getFirst().getIdVychodu().add("ulice");
        svet.getLast().getIdVychodu().add("byt");

        svet.add(lokace1);
        svet.add(lokace2);

        hrac.setIdLokace("byt");
        hrac.setIdAktualniLokace(svet);

        pohyb = new Pohyb(0, hrac, svet, item);
    }

    @Test
    void execute() {
        pohyb.execute("ulice");

        assertEquals("ulice", hrac.getAktualniLokace().getId());
    }
}