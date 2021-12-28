
import control.Controller;
import model.Menu.InstructionMenuModel;
import view.ViewInstructionMenu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Controller controller = new Controller();
        controller.run();
    }
}
