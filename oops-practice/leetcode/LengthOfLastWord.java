import java.util.*;
public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String : ");
        String s = sc.nextLine();
        String[] words = s.split(" ");
        System.out.println(words[words.length-1].length());
        sc.close();
    }
}
