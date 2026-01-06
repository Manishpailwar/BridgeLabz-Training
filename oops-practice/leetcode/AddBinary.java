import java.util.*;
public class AddBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String a = sc.next();
        String b = sc.next();
        sc.close();
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0 ;
        while(i>=0 && j>=0){
            int n = carry + (a.charAt(i)-'0') + (b.charAt(j)-'0') ;
            if(n > 1)
                carry = 1 ;
            else
                carry = 0 ;
            sb.append(n%2);
            i--;j--;
        }
        int ind = (i>j)?i:j;
        String s = (i>j)?a:b;
        while(ind >=0){
            int n = carry + (s.charAt(ind)-'0') ;
            if(n > 1)
                carry = 1 ;
            else 
                carry = 0 ;
            sb.append(n%2);
            ind--;
        }
        if(carry == 1)
        sb.append(carry);
        System.out.println(sb.reverse());
    }
}
