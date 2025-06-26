import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParsingTest {
   @Test
   void test_parse() {
       final var args = "A#:H,D#:Q,C#:W".split(",");
       final var melody = Main.parseMelody(args);

       final var note1 = new Note(NoteName.A_SHARP, NoteValue.HALF);
       final var note2 = new Note(NoteName.D_SHARP, NoteValue.QUARTER);
       final var note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);

       note1.setNextNote(note2);
       note2.setNextNote(note3);

       assertEquals(new Melody(note1), melody);
   }
}
