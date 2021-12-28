package control;

import com.googlecode.lanterna.input.KeyStroke;

public interface Observer {

    public void processKey(KeyStroke key);
}
