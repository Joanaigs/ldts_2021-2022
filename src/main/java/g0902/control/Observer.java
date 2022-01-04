package g0902.control;

import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public interface Observer {
   void processKey(KeyStroke key) throws IOException, InterruptedException;
}
