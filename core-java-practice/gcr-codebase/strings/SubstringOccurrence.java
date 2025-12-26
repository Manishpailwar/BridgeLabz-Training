import java.util.Scanner;

public class SubstringOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the main string:");
        String str = scanner.nextLine();
        System.out.println("Enter the substring to find:");
        String sub = scanner.nextLine();
        
        int count = countOccurrences(str, sub);
        System.out.println("Occurrences of \"" + sub + "\": " + count);
        scanner.close();
    }

    public static int countOccurrences(String str, String sub) {
        int count = 0;
        int index = 0;
        
        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }
}