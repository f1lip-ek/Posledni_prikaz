package game.command;

public class Pohyb implements Command{

    private int cislo;

    public Pohyb(int cislo) {
        this.cislo = cislo;
    }

    @Override
    public String execute(Object object) {
        if (cislo == 1){
            return "vypsani vychodu";
        }else {
            return "zmena mista";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}