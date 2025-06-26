/**
 * The ENUM NoteValue contains the note values(lenghts) WHOLE,HALF,QUARTER 
 */
public enum NoteValue {
    
    WHOLE("W"),
    HALF("H"),
    QUARTER("Q");
    
    // Attributes
    private final String abbreviation;

    // Methods
    // Constructor
    NoteValue(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    /**
     * Gets abbreviation of given element
     * @return String
     */
    public String getAbbreviation() {
        return this.abbreviation;
    }
    /**
     * Parses a user given string into its matching NoteValue object
     * @return NoteValue
     */
    public static NoteValue parse(String noteValueString) {
        for(NoteValue noteValue : NoteValue.values()) {
            if(noteValue.getAbbreviation().equals(noteValueString)) {
                return noteValue;
            }
        }
        throw new IllegalArgumentException("Nicht einlesbare Notenlänge:" + noteValueString);
    }
}
