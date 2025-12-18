import java.util.*;
public class Pallindrome {

    public static boolean isPalindrome(int x) {
       if(x < 0)return false ;
       int num = x;
       int rem = 0 ;
       while(num > 0){
        rem = rem*10 + num%10 ;
        num /= 10 ;
       }
       return rem == x ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int x = sc.nextInt();
        System.out.println(isPalindrome(x));
        sc.close();
    }
}
