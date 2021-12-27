package model.Menu.Options;

public enum MenuOptions {
    START("START"),
    SETTINGS("SETTINGS"),
    RANKINGS("RANKINGS"),
    EXIT("EXIT");
    private final String text;

    MenuOptions(String text) {
        this.text=text;
    }

    public String getText() {
        return text;
    }
}
