import java.util.*;
public class LastWordLen {

    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String s = sc.next();
        System.out.println(lengthOfLastWord(s));
        sc.close();
    }
}
