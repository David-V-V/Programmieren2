public class Note {
    
    // Attributes
    private NoteName name;
    private NoteValue value;
    private Note nextNote;

    // Constructor(s)
    Note(NoteName name, NoteValue value) {
        this.name = name;
        this.value = value;
    }
    Note(String name, String value) {
        this(NoteName.parse(name), NoteValue.parse(value));
    }

    // Methods
    // Getter
    /**
     * Getter for note name
     * @return NoteName
     */
    public NoteName getName() {
        return this.name;
    }
    /**
     * Getter for note value
     * @return NoteValue
     */
    public NoteValue getValue() {
        return this.value;
    }
    /**
     * Getter for next note
     * @return Note
     */
    public Note getNextNote() {
        return this.nextNote;
    }
    // Setter
    /**
     * Set next note attribute
     */
    public void setNextNote(Note note) {
        this.nextNote = note;
    }
    /**
     * Cheks if two notes are equal, they are if both name and value are the same 
     * @return boolean
     */
    public boolean equals(Note note) {
        return (this.name == note.getName() && this.value == note.getValue()) ? true : false;
    }
    /**
     * Returns string value of note object
     * @return String
     */
    public String toString() {
        return name.getAbbreviation() + ":" + value.getAbbreviation();
    }
    /**
     * returns frequency of note in Hz
     * @return double
     */
    public double getPitch() {
        return (Math.pow(2.0, this.name.gethalfToneStepsToA() / 12.0)) * 440;
    }
}
