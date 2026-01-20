package game.command;

public class Boj implements Command{

    private int cislo;

    public Boj(int cislo) {
        this.cislo = cislo;
    }

    @Override
    public String execute(Object object) {
        if (cislo == 1){
            return "zautoc";
        }else {
            return "vzdej se (zabije te)";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}