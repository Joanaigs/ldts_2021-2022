package model.Menu;

import model.Model;
import model.Pair;


import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RankingsMenuModel implements Model, MenuModel {
    List<Pair<String, Integer>> scores= new ArrayList<>() ;
    private boolean running;
    String fileLocation;

    public RankingsMenuModel(){
        readFile("Rankings");
        sortD();
        running=true;
    }

    public void readFile(String filename){

    }

    @Override
    public void setRunning(boolean running) {
        this.running=running;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    public void sortD(){

    }

    public void addScore(String str, int score){

    }

    public void updateFile() throws IOException {

    }

    public List<Pair<String, Integer>> getScores() {
        return scores;
    }
}
