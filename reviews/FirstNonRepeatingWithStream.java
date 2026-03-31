import java.util.*;
public class FirstNonRepeatingWithStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter String : ");
        String s = sc.next();
        List<Character> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i));
        }
        System.out.print("First Non Repeating Character is : ");
        list.stream().filter(n->s.indexOf(n)==s.lastIndexOf(n)).limit(1).forEach(System.out::println);
        sc.close();
    }
}
