/**
 * The ENUM NoteName contains all note names (exept flats) according to english standard 
 */
public enum NoteName {
   
    A("A",0),
    A_SHARP("A#",1),
    B("B",2),
    C("C",3),
    C_SHARP("C#",4),
    D("D",5),
    D_SHARP("D#",6),
    E("E",7),
    F("F",8),
    F_SHARP("F#",9),
    G("G",10),
    G_SHARP("G#",11);
    
    // Attributes
    private final String abbreviation;
    private final int halfToneStepsToA;

    // Methods
    // Constructor
    NoteName(String abbreviation, int halfToneStepsToA) {
        this.abbreviation = abbreviation;
        this.halfToneStepsToA = halfToneStepsToA;
    }
    /**
     * Gets abbreviation of given element
     * @return String
     */
    public String getAbbreviation() {
        return this.abbreviation;
    }
    /**
     * Gets hhalfToneStepsToA of given element
     * @return int
     */
    public int gethalfToneStepsToA() {
        return this.halfToneStepsToA;
    }
    /**
     * Parses a user given string into its matching NoteName object
     * @return NoteName
     */
    public static NoteName parse(String noteString) {
        
        for(NoteName note : NoteName.values()) {
            if(note.getAbbreviation().equals(noteString)) {
                return note;
            }
        }
        throw new IllegalArgumentException("Nicht einlesbare Note:" + noteString);
    }
}
