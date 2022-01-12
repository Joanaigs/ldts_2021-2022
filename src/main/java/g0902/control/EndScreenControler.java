package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import g0902.model.Menu.EndScreenModel;

import java.io.IOException;

public class EndScreenControler implements Observer {
    EndScreenModel endScreenModel;
    int nameSize;

    public EndScreenControler(EndScreenModel endScreenModel) {
        this.endScreenModel=endScreenModel;
        nameSize=0;
    }
    @Override
    public void processKey(KeyStroke key) throws IOException, InterruptedException {
        if(key.getKeyType() == KeyType.Enter){
            endScreenModel.setRunning(false);
        }
        if(nameSize<3){
            endScreenModel.addLetter(key.getCharacter());
            nameSize++;
        }

    }
}
