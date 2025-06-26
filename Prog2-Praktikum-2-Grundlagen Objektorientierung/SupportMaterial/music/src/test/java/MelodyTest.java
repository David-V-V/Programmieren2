import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MelodyTest {

//    @Test
//    void getLastNote() {
//        final var note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//
//        note1.setNextNote(note2);
//        note2.setNextNote(note3);
//
//        final var melody = new Melody(note1);
//        assertSame(note3, melody.getLastNote());
//    }
//
//    @Test
//    void toString_0() {
//        final var note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);
//        final var note5 = new Note(NoteName.F_SHARP, NoteValue.QUARTER);
//        final var note6 = new Note(NoteName.C_SHARP, NoteValue.QUARTER);
//
//        final var melody = new Melody(note1);
//        melody.addNote(note2);
//        melody.addNote(note3);
//        melody.addNote(note4);
//        melody.addNote(note5);
//        melody.addNote(note6);
//
//        assertEquals("A:W,B:W,C#:W,D#:H,F#:Q,C#:Q", melody.toString());
//    }
//
//    @Test
//    void toString_1() {
//        final var melody = new Melody(null);
//        assertEquals("", melody.toString());
//    }
//
   @Test
   void equals_0() {
       final var note1 = new Note(NoteName.A, NoteValue.WHOLE);
       final var note2 = new Note(NoteName.B, NoteValue.WHOLE);
       final var note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
       final var note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);
       final var note5 = new Note(NoteName.F_SHARP, NoteValue.QUARTER);
       final var note6 = new Note(NoteName.C_SHARP, NoteValue.QUARTER);

       note1.setNextNote(note2);
       note2.setNextNote(note3);
       note3.setNextNote(note4);
       note4.setNextNote(note5);
       note5.setNextNote(note6);

       final var melody1 = new Melody(note1);
       final var melody2 = new Melody(note1);
       final var melody3 = new Melody(note2);

       assertEquals(melody1, melody2);
       assertNotEquals(melody1, melody3);
       assertNotEquals(melody1, null);
       assertNotEquals(new Melody(null), melody1);
       assertEquals(new Melody(null), new Melody(null));
   }
//
//    @Test
//    void equals_1() {
//        final var melody1Note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var melody1Note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var melody1Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var melody1Note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);
//
//        final var melody2Note1 = new Note(NoteName.F, NoteValue.WHOLE);
//        final var melody2Note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var melody2Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var melody2Note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);
//
//        final var melody1 = new Melody(melody1Note1);
//        melody1.addNote(melody1Note2);
//        melody1.addNote(melody1Note3);
//        melody1.addNote(melody1Note4);
//
//        final var melody2 = new Melody(melody2Note1);
//        melody2.addNote(melody2Note2);
//        melody2.addNote(melody2Note3);
//        melody2.addNote(melody2Note4);
//
//        assertNotEquals(melody1, melody2);
//    }
//
//    @Test
//    void equals_2() {
//        final var melody1Note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var melody1Note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var melody1Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var melody1Note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);
//
//        final var melody2Note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var melody2Note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var melody2Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var melody2Note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);
//
//        final var melody1 = new Melody(melody1Note1);
//        melody1.addNote(melody1Note2);
//        melody1.addNote(melody1Note3);
//        melody1.addNote(melody1Note4);
//
//        final var melody2 = new Melody(melody2Note1);
//        melody2.addNote(melody2Note2);
//        melody2.addNote(melody2Note3);
//        melody2.addNote(melody2Note4);
//
//        assertEquals(melody1, melody2);
//    }
//
//    @Test
//    void equals_3() {
//        final var melody1Note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var melody1Note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var melody1Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var melody1Note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);
//
//        final var melody2Note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var melody2Note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var melody2Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//
//        final var melody1 = new Melody(melody1Note1);
//        melody1.addNote(melody1Note2);
//        melody1.addNote(melody1Note3);
//        melody1.addNote(melody1Note4);
//
//        final var melody2 = new Melody(melody2Note1);
//        melody2.addNote(melody2Note2);
//        melody2.addNote(melody2Note3);
//
//        assertNotEquals(melody1, melody2);
//    }
//
   @Test
   void contains() {
       final var note1 = new Note(NoteName.A, NoteValue.WHOLE);
       final var note2 = new Note(NoteName.B, NoteValue.WHOLE);
       final var note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
       final var note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);

       note1.setNextNote(note2);
       note2.setNextNote(note3);

       final var melody1 = new Melody(note1);

       assertTrue(melody1.contains(note1));
       assertTrue(melody1.contains(note2));
       assertTrue(melody1.contains(note3));
       assertFalse(melody1.contains(note4));
   }

   @Test
   void addNote0() throws Exception {
       final var note1 = new Note(NoteName.A, NoteValue.WHOLE);
       final var note2 = new Note(NoteName.B, NoteValue.WHOLE);
       final var note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
       final var note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);

       note1.setNextNote(note2);
       note2.setNextNote(note3);

       final var melody1 = new Melody(note1);

       assertFalse(melody1.contains(note4));
       assertSame(note3, melody1.getLastNote());
        melody1.addNote(note4);
       assertTrue(melody1.contains(note4));
       assertSame(note4, melody1.getLastNote());
   }
//
//    @Test
//    void addNote1() {
//        final var note0 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var note1 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var note2 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var note3 = new Note(NoteName.D_SHARP, NoteValue.HALF);
//
//        final var melody1 = new Melody(null);
//        melody1.addNote(note0);
//        melody1.addNote(note1);
//        melody1.addNote(note2);
//        melody1.addNote(note3);
//
//        assertTrue(melody1.contains(note0));
//        assertTrue(melody1.contains(note1));
//        assertTrue(melody1.contains(note2));
//        assertTrue(melody1.contains(note3));
//        assertSame(note0, melody1.getFirstNote());
//        assertSame(note3, melody1.getLastNote());
//    }
//
   @Test
   void replaceNote_replaceFirstNote() throws Exception{
       final var melody1Note1 = new Note(NoteName.A, NoteValue.WHOLE);
       final var melody1Note2 = new Note(NoteName.B, NoteValue.WHOLE);
       final var melody1Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
       final var melody1Note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);

       final var melody2Note1 = new Note(NoteName.F, NoteValue.WHOLE);
       final var melody2Note2 = new Note(NoteName.B, NoteValue.WHOLE);
       final var melody2Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
       final var melody2Note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);

       final var melody1 = new Melody(melody1Note1);
       melody1.addNote(melody1Note2);
       melody1.addNote(melody1Note3);
       melody1.addNote(melody1Note4);

       final var melody2 = new Melody(melody2Note1);
       melody2.addNote(melody2Note2);
       melody2.addNote(melody2Note3);
       melody2.addNote(melody2Note4);

       assertNotEquals(melody1, melody2);
       melody2.replaceNote(new Note(NoteName.A, NoteValue.WHOLE), 0);
       assertEquals(melody1, melody2);
   }
//
//
//    @Test
//    void replaceNote_replaceSecondNote() {
//        final var melody1Note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var melody1Note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var melody1Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var melody1Note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);
//
//        final var melody2Note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var melody2Note2 = new Note(NoteName.F, NoteValue.WHOLE);
//        final var melody2Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var melody2Note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);
//
//        final var melody1 = new Melody(melody1Note1);
//        melody1.addNote(melody1Note2);
//        melody1.addNote(melody1Note3);
//        melody1.addNote(melody1Note4);
//
//        final var melody2 = new Melody(melody2Note1);
//        melody2.addNote(melody2Note2);
//        melody2.addNote(melody2Note3);
//        melody2.addNote(melody2Note4);
//
//        assertNotEquals(melody1, melody2);
//        melody2.replaceNote(new Note(NoteName.B, NoteValue.WHOLE), 1);
//        assertEquals(melody1, melody2);
//    }
//
//    @Test
//    void replaceNote_replaceLastNote() {
//        final var melody1Note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var melody1Note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var melody1Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var melody1Note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);
//
//        final var melody2Note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var melody2Note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var melody2Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var melody2Note4 = new Note(NoteName.F, NoteValue.HALF);
//
//        final var melody1 = new Melody(melody1Note1);
//        melody1.addNote(melody1Note2);
//        melody1.addNote(melody1Note3);
//        melody1.addNote(melody1Note4);
//
//        final var melody2 = new Melody(melody2Note1);
//        melody2.addNote(melody2Note2);
//        melody2.addNote(melody2Note3);
//        melody2.addNote(melody2Note4);
//
//        assertNotEquals(melody1, melody2);
//        melody2.replaceNote(new Note(NoteName.D_SHARP, NoteValue.HALF), 3);
//        assertEquals(melody1, melody2);
//    }
//
//    @Test
//    void replaceNote_negativeIndex_IndexOutOfBounds() {
//        final var melody1Note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var melody1Note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var melody1Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var melody1Note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);
//
//        final var melody1 = new Melody(melody1Note1);
//        melody1.addNote(melody1Note2);
//        melody1.addNote(melody1Note3);
//        melody1.addNote(melody1Note4);
//
//        assertThrows(IndexOutOfBoundsException.class, () -> melody1.replaceNote(new Note(NoteName.A, NoteValue.HALF), -1));
//    }
//
//    @Test
//    void replaceNote_tooLargeIndex_IndexOutOfBounds() {
//        final var melody1Note1 = new Note(NoteName.A, NoteValue.WHOLE);
//        final var melody1Note2 = new Note(NoteName.B, NoteValue.WHOLE);
//        final var melody1Note3 = new Note(NoteName.C_SHARP, NoteValue.WHOLE);
//        final var melody1Note4 = new Note(NoteName.D_SHARP, NoteValue.HALF);
//
//        final var melody1 = new Melody(melody1Note1);
//        melody1.addNote(melody1Note2);
//        melody1.addNote(melody1Note3);
//        melody1.addNote(melody1Note4);
//
//        assertThrows(IndexOutOfBoundsException.class, () -> melody1.replaceNote(new Note(NoteName.A, NoteValue.HALF), 4));
//    }
}
