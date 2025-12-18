import java.util.*;
public class ReverseString {

    public static char[] reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp ;
        }
        return s ;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int size = sc.nextInt();
        char[] s = new char[size];
        for(int i=0;i<s.length;i++){
            String str = sc.next();
            s[i] = str.charAt(0);
        }
        System.out.println(Arrays.toString(reverseString(s)));
        sc.close();
    }
}
