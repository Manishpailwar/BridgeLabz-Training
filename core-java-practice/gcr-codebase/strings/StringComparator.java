import java.util.Scanner;

public class StringComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String 1:");
        String s1 = scanner.nextLine();
        System.out.println("Enter String 2:");
        String s2 = scanner.nextLine();
        
        int result = compareStrings(s1, s2);
        
        if (result < 0) {
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
        } else if (result > 0) {
            System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\" in lexicographical order");
        } else {
            System.out.println("Both strings are equal.");
        }
        scanner.close();
    }

    public static int compareStrings(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if (c1 != c2) {
                return c1 - c2;
            }
        }
        
        // If one is a substring of the other, the shorter one comes first
        return len1 - len2;
    }
}