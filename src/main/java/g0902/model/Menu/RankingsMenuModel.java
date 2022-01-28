package g0902.model.Menu;

import g0902.model.Model;
import g0902.model.Pair;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RankingsMenuModel implements Model, MenuModel {
    List<Pair<String, Integer>> scores= new ArrayList<>() ;
    private boolean running;
    String fileLocation;

    public RankingsMenuModel() throws FileNotFoundException {
        readFile("Rankings");
        sortD();
        running=true;
    }

    public void readFile(String filename) throws FileNotFoundException {
        scores.clear();
        String rootPath = new File(System.getProperty("user.dir")).getPath();
        fileLocation = rootPath + "/src/main/resources/"+filename ;

        File file = new File(fileLocation);
        Scanner myReader = new Scanner(file, Charset.defaultCharset().name());
        if(!myReader.hasNext())
            return;
        myReader.nextLine();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            List<String> dt= Stream.of(data.split(" "))
                    .map (elem -> new String(elem))
                    .collect(Collectors.toList());
            scores.add(new Pair(dt.get(1), Integer.parseInt(dt.get(0))));
        }
        myReader.close();
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
        scores.sort(Comparator.comparing(p -> -p.getR()));
    }

    public void addScore(String str, int score) {
        scores.add(new Pair<>(str, score));
    }

    public void updateFile() throws IOException {
        sortD();
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileLocation), Charset.defaultCharset());
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

    public void setScores(List<Pair<String, Integer>> scores){this.scores = scores; }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

}
