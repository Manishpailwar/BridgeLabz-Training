import java.util.Scanner;

public class WordReplacer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        System.out.println("Enter the word to replace:");
        String target = scanner.next();
        System.out.println("Enter the replacement word:");
        String replacement = scanner.next();
        
        String result = replaceWord(sentence, target, replacement);
        System.out.println("Modified Sentence: " + result);
        scanner.close();
    }

    public static String replaceWord(String sentence, String target, String replacement) {
        String[] words = sentence.split(" ");
        String result = "";
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                result += replacement;
            } else {
                result += words[i];
            }
            if (i < words.length - 1) {
                result += " ";
            }
        }
        return result;
    }
}