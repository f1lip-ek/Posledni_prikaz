package game.lokace;

import game.itemy.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LokaceTest {

    Lokace l;

    Item item1;
    Item item2;
    ArrayList<Item> itemy;
    ArrayList<Lokace> lokace;
    Lokace lokace1;
    Lokace lokace2;

    @BeforeEach
    void setUp() {
        itemy = new ArrayList<>();
        lokace = new ArrayList<>();
        l = new Lokace("byt", new ArrayList<>());
        item1 = new Item("pistole", "Pistole");
        item2 = new Item("kamera", "Sledovaci Zarizeni");
        lokace1 = new Lokace("recepce", new ArrayList<>());
        lokace2 = new Lokace("ulice", new ArrayList<>());


        itemy.add(item1);
        itemy.add(item2);

        lokace.add(lokace1);
        lokace.add(lokace2);
    }

    @Test
    void setItemyVLokaci() {

        l.getItems().add(item1.getId());
        l.getItems().add(item2.getId());

        l.setItemyVLokaci(itemy);

        assertEquals(itemy, l.getItemyVLokaci());

    }

    @Test
    void setVychody() {
        l.getIdVychodu().add("recepce");
        l.getIdVychodu().add("ulice");

        l.setVychody(lokace);

        assertEquals(lokace, l.getVychody());
    }
}