import java.util.Scanner;
class Solutions {
    public int reverse(int x) {
        long rem = 0;
        if(x < 0){
        x = Math.abs(x);
         while(x>0){
            rem = rem*10 + x%10 ;
            if(rem < -2147483648 || rem > 2147483647)
             return 0;
            x = x/10 ;
        }
        rem = -rem;
        int n = (int)rem;
        return n;
        }
        else{
        while(x>0){
            rem = rem*10 + x%10 ;
            if(rem < -2147483648 || rem > 2147483647)
            return 0;
            x = x/10 ;
        }
        int n = (int)rem;
        return n;
        }
    }
}
public class ReverseInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        Solutions solution = new Solutions();
        sc.close();
        System.out.println(solution.reverse(n));
    }
}
