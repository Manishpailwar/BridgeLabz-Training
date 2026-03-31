import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        
        String longest = findLongestWord(sentence);
        System.out.println("Longest word: " + longest);
        scanner.close();
    }

    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+"); // Split by whitespace
        String longest = "";
        
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }
}