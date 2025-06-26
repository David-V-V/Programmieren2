public class Melody {
    
    // Attributes
    private Note firstNote;

    // Constructor(s)
    Melody(Note firstNote) {
        this.firstNote = firstNote;
    }

    // Methods
    // Getter
    /**
     * Getter for first note attribute
     * @return Note
     */
    public Note getFirstNote() {
        return this.firstNote;
    }
    /**
     * Getter for last note attribute
     * @return Note
     */
    public Note getLastNote() {
        Note currentNote = this.firstNote;
        while(currentNote != null) {
            if(currentNote.getNextNote() == null) {
                break;
            } 
            currentNote = currentNote.getNextNote();
        }
        return currentNote;
    }
    /**
     * Cheks if this melody already contains the exact Note obejct
     * @return void
     */
    public boolean contains(Note note) {
        Note currentNote = this.firstNote;
        while(currentNote != null) {
            if(currentNote == note) {
                return true;
            }else {
                currentNote = currentNote.getNextNote();
            }
        }
        // Not found in loop means not contained (false)
        return false;
    }
    /**
     * adds Note to end of the melody
     * @return void
     */
    public void addNote(Note note) throws Exception {
        if(this.contains(note)) {
            throw new Exception("Same note object already part of melody!");
        }
        // Handle "pointers"
        this.getLastNote().setNextNote(note);
    }
    /**
     * Replace a note at given index with new note
     * @return void
     */
    public void replaceNote(Note newNote, int index) throws Exception {
        // Validate params
        if(index < 0 || index > this.length()) {
            throw new IndexOutOfBoundsException("Index "+index+" is out of bounds");
        }
        if(this.contains(newNote)) {
            throw new Exception("Same note object already part of melody!");
        }
        // Replace
        Note lastNote = null;
        Note currentNote = this.firstNote;
        int currentIndex = 0;
        while(currentNote != null) {
            // Do the replace at index
            if(currentIndex == index) {
                lastNote.setNextNote(newNote);
                newNote.setNextNote(currentNote.getNextNote());
            }
            // Handle "pointer"
            lastNote = currentNote;
            currentNote = currentNote.getNextNote();
            currentIndex++;
        }
    }
    /**
     * Returns string value of melody object
     * @return String
     */
    public String toString() {
        String returnString = "";
        Note currentNote = firstNote;
        // Loop over linked list and build string
        while(currentNote != null) {
            returnString += currentNote.getNextNote() == null ? currentNote.toString() : currentNote.toString() + ",";
            currentNote = currentNote.getNextNote();
        }
        return returnString;
    }
    /**
     * Checks if two melodies are equal, they are if every note is the same
     * @return boolean
     */
    public boolean equals(Melody melody) {
        if(this.length() != melody.length()) return false;
        Note currentNoteM1 = this.firstNote;
        Note currentNoteM2 = melody.firstNote;
        // Loop over linked lists and compare notes
        while(currentNoteM1 != null && currentNoteM2 != null) {
            // Return false if different notes found
            if (!(currentNoteM1.equals(currentNoteM2))) return false;
            currentNoteM1 = currentNoteM1.getNextNote();
            currentNoteM2 = currentNoteM2.getNextNote();
        }
        return true;
    }
    // Private methods
    // Get length of linked list
    private int length() {
        int length = 0;
        Note currentNote = this.firstNote;
        while(currentNote != null) {
            length++;
            currentNote = currentNote.getNextNote();
        }
        return length;
    }
}
