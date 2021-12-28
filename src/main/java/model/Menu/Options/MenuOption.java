package model.Menu.Options;

public enum MenuOption {
    START("START"),
    SETTINGS("SETTINGS"),
    RANKINGS("RANKINGS"),
    EXIT("EXIT");
    private final String text;

    MenuOption(String text) {
        this.text=text;
    }

    @Override
    public String toString() {
        return text;
    }
}
