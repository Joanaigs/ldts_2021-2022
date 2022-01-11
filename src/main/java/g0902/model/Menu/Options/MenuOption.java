package g0902.model.Menu.Options;

public enum MenuOption {
    START("START"),
    INSTRUCTIONS("INSTRUCTIONS"),
    LEADERBOARD("LEADERBOARD"),
    EXIT("EXIT");
    private final String text;

    MenuOption(String text) {
        this.text=text;
    }

    public String getText() {
        if (text.length()==0)
            return "";
        else
            return text;
    }
}
