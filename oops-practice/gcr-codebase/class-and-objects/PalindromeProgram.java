
 // Program to Check Palindrome String
 // Checks if text is palindrome ignoring spaces and case.
 
class PalindromeChecker {
    String text;

    public PalindromeChecker(String text) {
        this.text = text;
    }

    public void checkAndDisplay() {
        // Normalize: remove non-alphanumeric characters and convert to lowercase
        String cleanText = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        String reversed = new StringBuilder(cleanText).reverse().toString();

        if (cleanText.equals(reversed)) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }
}

public class PalindromeProgram {
    public static void main(String[] args) {
        PalindromeChecker p1 = new PalindromeChecker("A man a plan a canal Panama");
        p1.checkAndDisplay();

        PalindromeChecker p2 = new PalindromeChecker("Hello");
        p2.checkAndDisplay();
    }
}