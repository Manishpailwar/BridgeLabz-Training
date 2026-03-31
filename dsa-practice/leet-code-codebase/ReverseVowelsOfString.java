import java.util.*;
class VowelsReverse {
    public String reverseVowels(String s) {
        Stack<Character> vowel = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
                vowel.push(c);
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
                sb.append(vowel.pop());
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
public class ReverseVowelsOfString {
    public static void main(String[] args) {
        VowelsReverse vr = new VowelsReverse();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(vr.reverseVowels(s));
        sc.close();
    }
}
