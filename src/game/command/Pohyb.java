package game.command;

import game.postavy.Entita;

import java.util.Arrays;

/**
 * Trida pro command ktery meni lokaci hrace a pro command ktery zobrazuje kam hrac muze jit z aktualni lokace
 */
public class Pohyb implements Command{

    private final int cislo;
    private final Entita hrac;

    public Pohyb(int cislo, Entita hrac) {
        this.cislo = cislo;
        this.hrac = hrac;
    }

    /**
     * Metoda pro command ktery meni lokaci hrace a take zobrazuje kam hrac muze jit
     * @param text urcuje misto kam se ma hrac presunout
     * @return textovy retezec ktery hrace usvedci ze se akce opravdu stala
     */
    @Override
    public String execute(String text) {
        if (cislo == 1){
            return "Muzes jit na: " + Arrays.toString(hrac.getAktualniLokace().getIdVychodu());
        }else {
            hrac.setIdLokace(text);
            return "Lokace zmenena na: " + text;
        }
    }

    /**
     * Metoda ktera rika jestli command ukoncuje hru nebo ne
     * @return false protoze command neukoncuje hru
     */
    @Override
    public boolean exit() {
        return false;
    }
}