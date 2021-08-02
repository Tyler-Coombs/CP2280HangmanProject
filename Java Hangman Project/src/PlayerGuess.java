import java.util.List;
import java.util.Scanner;

public class PlayerGuess {
    public static boolean getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses) {
        while (true) {
            System.out.println("Please enter a letter:");
            String letterGuess = keyboard.nextLine();
            int length = letterGuess.length();
            if (length > 1 || length < 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }
            else {
                playerGuesses.add(letterGuess.charAt(0));
            }

            return word.contains(letterGuess);
        }
    }
}
