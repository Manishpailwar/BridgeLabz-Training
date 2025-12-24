package reviews;
import java.util.*;
public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String s = sc.next();
        boolean b = true ;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)!=s.charAt(j)){
                    b = true ;
            }
            else {
                b = false ;
                break ;
            }
     }
     if(b){
        System.out.println(s.charAt(i));
        break ;
     }
        }
        sc.close();
    }
}
