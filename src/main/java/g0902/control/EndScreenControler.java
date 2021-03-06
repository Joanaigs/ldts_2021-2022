package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import g0902.model.Menu.EndScreenModel;


public class EndScreenControler implements Observer {
    final EndScreenModel endScreenModel;
    int nameSize;

    public EndScreenControler(EndScreenModel endScreenModel) {
        this.endScreenModel=endScreenModel;
        nameSize=0;
    }
    @Override
    public void processKey(KeyStroke key) {
        if(nameSize<3){
            if (key.getKeyType() == KeyType.Character) {
                endScreenModel.addLetter(key.getCharacter());
                nameSize++;
            }
        } else if(key.getKeyType() == KeyType.Enter) {
            endScreenModel.setRunning(false);
        }
    }
}
