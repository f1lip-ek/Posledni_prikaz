package game.command;

public class VezmiPredmet implements Command{

    private int cislo;

    public VezmiPredmet(int cislo) {
        this.cislo = cislo;
    }

    @Override
    public String execute(Object object) {
        if (cislo == 1){
            return "ziskat predmet: " + object;
        }else {
            return "prohledani okoli";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}