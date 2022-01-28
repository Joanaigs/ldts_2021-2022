package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;

public class ReadKeys implements Runnable {
    volatile Screen screen = null;
    final ArrayList<Observer> observers;

    public ReadKeys(){
        observers = new ArrayList<>();
    }

    public void addObserver(Observer obs){
        observers.add(obs);
    }

    public void removeObserver(Observer obs){
        observers.remove(obs);
    }

    public void setScreen(Screen screen) {this.screen = screen;}

    public Screen getScreen() {return screen;}

    @Override
    public void run() {
        try {
            while (true) {
                if(screen ==null || observers.isEmpty())
                    continue;

                KeyStroke keyStroke = screen.readInput();
                for(Observer observer: observers){
                    observer.processKey(keyStroke);
                }
            }
        }catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
    }
    }
    public ArrayList<Observer> getObservers(){return observers;}
}