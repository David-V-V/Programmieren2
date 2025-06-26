import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Declarations
        int bits;
        int max;

        // Init with user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Anzahl der Bits ihrer Zahl?");
        bits = scanner.nextInt();
        // Consume \n
        scanner.nextLine();
        max = (int) Math.pow(2, bits);

        // Print out list(s) and gather bits of guessed number
        String guessedNumber = "";
        for(int i = 0; i < bits; i++) {
            System.out.println("Ist ihre Zahl in dieser Liste enthalten? (j/n)");
            printNumbersWithBit(max, i);
            guessedNumber += scanner.nextLine().trim().toLowerCase();
        }

        // Convert bit string to int
        guessedNumber = guessedNumber.replace('j', '1');
        guessedNumber = guessedNumber.replace('n', '0');
        // Reverse string
        String guessedNumberReverse = "";
        for(int i = guessedNumber.length() - 1; i >= 0; i--) {
            guessedNumberReverse += guessedNumber.charAt(i);
        }
        int guessedInt = Integer.parseInt(guessedNumberReverse, 2);
        System.out.println("Ihre Zahl ist:" + guessedInt + "!");
        scanner.close();
    }


private static void printNumbersWithBit(int max, int bit) {

    // Check which numbers have 1 at position bit
    ArrayList<Integer> numberList = new ArrayList<Integer>();
    for(int i = 1; i < max; i++) {
        int shiftedInt = i >> bit;
        if(shiftedInt % 2 == 1) {
            numberList.add(i);
        }
    }

    // Print them 
    numberList.forEach(number -> System.out.print(number + " " ));
}
}