package game.command;

public class VezmiPredmet implements Command{

    private int cislo;

    public VezmiPredmet(int cislo) {
        this.cislo = cislo;
    }

    @Override
    public String execute() {
        if (cislo == 1){
            return "";
        }else {
            return "";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}