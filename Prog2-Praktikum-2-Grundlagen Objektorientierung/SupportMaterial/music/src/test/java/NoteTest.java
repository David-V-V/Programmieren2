import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoteTest {

   @Test
   void getPitch_A() {
       final var note = new Note(NoteName.A, NoteValue.WHOLE);
       assertEquals(440.0, note.getPitch());
   }

   @Test
   void getPitch_B() {
       final var note = new Note(NoteName.B, NoteValue.WHOLE);
       assertEquals(493.8833029565146, note.getPitch());
   }

   @Test
   void equals() {
       final var note1 = new Note(NoteName.A, NoteValue.WHOLE);
       final var note2 = new Note(NoteName.A, NoteValue.WHOLE);
       final var note3 = new Note(NoteName.B, NoteValue.WHOLE);
       final var note4 = new Note(NoteName.A, NoteValue.HALF);

       assertEquals(note1, note2);
       assertNotEquals(note1, note3);
       assertNotEquals(note1, note4);

       assertEquals(note1, note1);
       assertNotEquals(note1, null);
       assertNotEquals(null, note1);
   }
}
