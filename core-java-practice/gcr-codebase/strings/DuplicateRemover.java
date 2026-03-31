import java.util.Scanner;

public class DuplicateRemover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        
        String result = removeDuplicates(input);
        System.out.println("String after removing duplicates: " + result);
        scanner.close();
    }

    public static String removeDuplicates(String str) {
        String result = "";
        char[] chars = str.toCharArray();
        
        for (char c : chars) {
            // Check if character is already in the result
            if (result.indexOf(c) == -1) {
                result += c;
            }
        }
        return result;
    }
}