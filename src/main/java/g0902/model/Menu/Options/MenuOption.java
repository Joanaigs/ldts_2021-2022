package g0902.model.Menu.Options;

public enum MenuOption {
    START("START"),
    INSTRUCTIONS("INSTRUCTIONS"),
    RANKINGS("RANKINGS"),
    EXIT("EXIT");
    private final String text;

    MenuOption(String text) {
        this.text=text;
    }

    public String getText() {
        return text;
    }
}
