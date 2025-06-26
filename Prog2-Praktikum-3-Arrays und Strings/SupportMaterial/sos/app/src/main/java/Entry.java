public enum Entry {

    S_UNSCORED('S', false),
    O_UNSCORED('O', false),
    S_SCORED('$', true),
    O_SCORED('0', true);

    private final char display;
    private final boolean scored;

    // Constructor
    Entry(char display, boolean scored) {
        this.display = display;
        this.scored = scored;
    }

    // Getter
    public char getDisplay() {
        return display;
    }

    public boolean isScored() {
        return scored;
    }

    // Methods
    // Get Entry object for given char
    public static Entry fromDisplay(char display) {
        for(Entry entry : Entry.values()) {
            if(entry.getDisplay() == display) {
                return entry;
            }
        }
        return null;
    }

    // Get scored variant
    public Entry toScored() {
        switch(this) {
            case O_UNSCORED:
                return Entry.O_SCORED;
            case S_UNSCORED:
                return Entry.S_SCORED;
            default:
                return this;
        }
    }

    // Get unscored variant
    public Entry toUnscored() {
        switch(this) {
            case O_SCORED:
                return Entry.O_UNSCORED;
            case S_SCORED:
                return Entry.S_UNSCORED;
            default:
                return this;
        }
    }
}
