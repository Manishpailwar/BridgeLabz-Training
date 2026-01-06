import java.util.*;
public class ReverseStringg{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String : ");
        String s = sc.nextLine();
        for(int i=s.length();i<=0;i--){
            System.out.print(s.charAt(i));
        }
        sc.close();
    }
}
