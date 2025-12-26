import java.util.Scanner;

public class FrequencyCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        
        char mostFrequent = findMostFrequentChar(input);
        System.out.println("Most Frequent Character: '" + mostFrequent + "'");
        scanner.close();
    }

    public static char findMostFrequentChar(String str) {
        int[] freq = new int[256]; // ASCII size
        char[] chars = str.toCharArray();
        
        // Count frequencies
        for (char c : chars) {
            freq[c]++;
        }
        
        int maxCount = -1;
        char maxChar = ' ';
        
        // Find max
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > maxCount) {
                maxCount = freq[i];
                maxChar = (char) i;
            }
        }
        return maxChar;
    }
}