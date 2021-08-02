import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        String difficulty;
        String word = null;

        System.out.println("HANGMAN\n");

        while (true) {
            System.out.print("Choose game mode: hard, medium, easy >> ");
            difficulty = keyboard.nextLine();
            if (difficulty.toLowerCase().equals("hard")) {
                Scanner scanner = new Scanner(new File("/Users/tylercoombs/Desktop/Java Hangman Project/HardWords.txt"));
                List<String> words = new ArrayList<>();

                while (scanner.hasNext()) {
                    words.add(scanner.nextLine());
                }

                Random rand = new Random();
                word = words.get(rand.nextInt(words.size()));
                break;
            } else if (difficulty.toLowerCase().equals("medium")) {
                Scanner scanner = new Scanner(new File("/Users/tylercoombs/Desktop/Java Hangman Project/MediumWords.txt"));
                List<String> words = new ArrayList<>();

                while (scanner.hasNext()) {
                    words.add(scanner.nextLine());
                }

                Random rand = new Random();
                word = words.get(rand.nextInt(words.size()));
                break;
            } else if (difficulty.toLowerCase().equals("easy")) {
                Scanner scanner = new Scanner(new File("/Users/tylercoombs/Desktop/Java Hangman Project/EasyWords.txt"));
                List<String> words = new ArrayList<>();

                while (scanner.hasNext()) {
                    words.add(scanner.nextLine());
                }

                Random rand = new Random();
                word = words.get(rand.nextInt(words.size()));
                break;
            } else {
                System.out.println("Invalid game mode choice.");
                continue;
            }
        }

        List<Character> playerGuesses = new ArrayList<>();

        Integer wrongCount = 0;

        while (true) {
            PrintHangedMan.printHangedMan(wrongCount);

            if (wrongCount >= 6) {
                System.out.println("You lose!");
                System.out.println("The word was: " + word);
                break;
            }

            PrintWordState.printWordState(word, playerGuesses);
            if (!PlayerGuess.getPlayerGuess(keyboard, word, playerGuesses)) {
                wrongCount++;
            }

            if (PrintWordState.printWordState(word, playerGuesses)) {
                System.out.println("You win!");
                break;
            }

            System.out.println("Please enter your guess for the word:");
            if (keyboard.nextLine().equals(word)) {
                System.out.println("You win!");
                break;
            } else {
                System.out.println("Nope! Try again.");
            }
        }
    }
}
