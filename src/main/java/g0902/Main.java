package g0902;

import g0902.control.Controller;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Controller controller = new Controller();
        controller.run();
    }
}
