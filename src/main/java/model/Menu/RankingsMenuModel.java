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
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            fileLocation = rootPath + "/src/main/resources/"+filename ;

            File file = new File(fileLocation);
            Scanner myReader = new Scanner(file);
            myReader.nextLine();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                List<String> dt= Stream.of(data.split(" "))
                        .map (elem -> new String(elem))
                        .collect(Collectors.toList());
                scores.add(new Pair(dt.get(1), Integer.parseInt(dt.get(0))));
            }
            myReader.close();
            System.out.println(scores.get(1).getR());
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
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
        Collections.sort(scores, Comparator.comparing(p -> -p.getR()));
    }

    public void addScore(String str, int score) throws IOException {
        scores.add(new Pair<>(str, score));
        updateFile();
    }

    public void updateFile() throws IOException {
        sortD();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation));
        writer.write("score name\n");
        for(Pair<String, Integer> pair: scores)
        {
            writer.write(pair.getR()+" "+pair.getL()+'\n');
        }
        writer.close();
    }

    public List<Pair<String, Integer>> getScores() {
        return scores;
    }
}
