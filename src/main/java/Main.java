
import control.Controller;
import model.Menu.InstructionMenuModel;
import model.Menu.MainMenuModel;
import view.ViewInstructionMenu;
import view.ViewMainMenu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Controller controller = new Controller();
        controller.run();
    }
}
