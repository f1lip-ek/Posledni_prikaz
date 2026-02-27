package game.command;

import game.postavy.Entita;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UlozitHru implements Command{

    private Entita hrac;

    public UlozitHru(Entita e){
        this.hrac = e;
    }

    @Override
    public String execute(String text) {
        return writeToFile();
    }

    @Override
    public boolean exit() {
        return false;
    }

    public String writeToFile(){
        try{
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("hrac.dat"));
            stream.writeObject(hrac);
            stream.close();
            return "ulozeno";
        } catch (IOException e) {
            return "mas to blbe";
        }
    }
}
