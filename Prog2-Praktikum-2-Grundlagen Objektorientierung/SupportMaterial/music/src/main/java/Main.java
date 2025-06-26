import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {
        // TEST
        Note notus = new Note(NoteName.B, NoteValue.WHOLE);
        notus.getPitch();
        final var melody = parseMelody(args);
        final Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println("(A)dd note, (R)eplace note, (D)isplay melody, (Q)uit");
            input = scanner.next().toUpperCase();
            switch (input) {
                case "A" -> {
                    System.out.println("Enter your Note!");
                    final var noteString = scanner.next();
                    try {
                        final var split = noteString.split(":");
                        final var note = new Note(split[0], split[1]);
                        melody.addNote(note);
                    } catch (final ArrayIndexOutOfBoundsException e) {
                        System.out.println("Can not parse Index '" + noteString + "'. Try Again!");
                    }catch (final Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "R" -> {
                    System.out.println("Enter your Note!");
                    final var split = scanner.next().split(":");
                    final var note = new Note(split[0], split[1]);
                    System.out.println("Enter the Index!");
                    final var indexString = scanner.next();
                    try {
                        final var index = Integer.parseInt(indexString);
                        melody.replaceNote(note, index);
                    } catch (final NumberFormatException e) {
                        System.out.println("Can not parse Index '" + indexString + "'. Try Again!");
                    } catch (final IndexOutOfBoundsException e) {
                        System.out.println("Index '" + indexString + "' is out of bounds. Try Again!");
                    } catch (final Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "D" -> {
                    System.out.println(melody);
                }
                default -> System.out.println("Invalid Input!");
            }
        } while (!input.equals("Q"));
        scanner.close();
    }

    public static Melody parseMelody(final String[] args) {
        if (args == null || args.length == 0) {
            return new Melody(null);
        }
        final var firstNoteString = args[0].split(",");
        final var fistNoteSplit = firstNoteString[0].split(":");
        final var firstNote = new Note(fistNoteSplit[0], fistNoteSplit[1]);
        Note currentNote = firstNote;
        for (var i = 1; i < args.length; i++) {
            final var split = args[i].split(":");
            final var note = new Note(split[0], split[1]);
            currentNote.setNextNote(note);
            currentNote = note;
        }
        final var melody = new Melody(firstNote);
        return melody;
    }
}
