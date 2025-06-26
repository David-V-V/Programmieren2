import java.util.Scanner;

public class SOS {

    private Entry[][] board;

    // Constructor
    SOS(Entry[][] board) {
        this.board = board;
    }

    // Methods
    // Get example board
    public static Entry[][] getExample() {
        char[][] boardChar = new char[][] {
                { ' ', ' ', ' ', ' ', ' ', 'S' },
                { ' ', ' ', 'S', ' ', '$', ' ' },
                { ' ', 'O', ' ', 'S', '0', ' ' },
                { ' ', 'S', ' ', ' ', '$', ' ' },
                { ' ', ' ', ' ', ' ', ' ', ' ' },
                { ' ', ' ', ' ', 'S', ' ', 'O' }
        };
        // Convert
        Entry[][] boardEntry = new Entry[6][6];
        for (int row = 0; row < boardChar.length; row++) {
            for (int col = 0; col < boardChar[row].length; col++) {
                if (boardChar[row][col] == ' ')
                    continue;
                boardEntry[row][col] = Entry.fromDisplay(boardChar[row][col]);
            }
        }
        return boardEntry;
    }

    // Checks if board is valid
    public static void checkBoard(Entry[][] board) {
        try {
            // Check if board is square, by comparing length of each row with number of rows
            boolean isSquare = true;
            for (int row = 0; row < board.length; row++) {
                if (board[row].length != board.length) {
                    isSquare = false;
                    break;
                }
            }
            // Check square and size criteria (atleast 3), if check fails, throw exeption
            if (!(board.length >= 3) || !isSquare) {
                throw new IllegalArgumentException("Bord Format nicht valide! (quadratisch)");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Bord Format nicht valide! (quadratisch)");
        }
    }

    // Print board
    public static void printBoard(Entry[][] board) {
        // Check input board
        checkBoard(board);
        String resultString = "  ";
        // Row seperator
        String rowSeperatoString = "  ";
        // Build top part
        // Build indicies on top and row seperator
        for (int i = 0; i < board.length; i++) {
            resultString += " " + i;
            rowSeperatoString += "+-";
        }
        rowSeperatoString += "+";
        resultString += "\n" + rowSeperatoString + "\n";

        // Build board with entry values and seperator string
        for (int i = 0; i < board.length; i++) {
            resultString += i + " ";
            for (int j = 0; j < board[i].length; j++) {
                resultString += board[i][j] == null ? "| " : "|" + board[i][j].getDisplay();
            }
            resultString += "|\n" + rowSeperatoString + "\n";
        }
        System.out.println(resultString);
    }

    // Checks if board is full
    public static boolean boardFull(Entry[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Create empty board
        Entry[][] board = new Entry[3][3];

        while (!SOS.boardFull(board)) {
            SOS.printBoard(board);
            try {
                // Get user input
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter row : ");
                int row = scanner.nextInt();
                System.out.println("Enter col : ");
                int col = scanner.nextInt();
                System.out.println("Enter entry (S or O) : ");
                scanner.nextLine();
                String entry = scanner.nextLine().trim().toUpperCase();
                // Check for valid entry char
                if(!(entry == "S" || entry == "O")) throw new IllegalArgumentException();
                // Set entry in board
                board[row][col] = Entry.fromDisplay(entry.charAt(0));
            } catch (Exception e) {
                System.out.println(
                        "Eine der Eingaben war inkorrekt, row und col müssen zahl sein, entry entweder S oder O!");
            }
        }

    }
}
