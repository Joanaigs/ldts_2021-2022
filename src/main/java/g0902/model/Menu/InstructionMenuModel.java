package g0902.model.Menu;

import g0902.model.Model;

public class InstructionMenuModel implements Model, MenuModel {
    private boolean running;
    public InstructionMenuModel(){running=true;}

    @Override
    public void setRunning(boolean running){this.running=running;}

    @Override
    public boolean isRunning(){return running;}
}
