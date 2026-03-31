import java.util.Scanner;

public class CharacterRemover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        System.out.println("Enter character to remove:");
        char charToRemove = scanner.next().charAt(0);
        
        String result = removeCharacter(input, charToRemove);
        System.out.println("Modified String: \"" + result + "\"");
        scanner.close();
    }

    public static String removeCharacter(String str, char ch) {
        String result = "";
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c != ch) {
                result += c;
            }
        }
        return result;
    }
}