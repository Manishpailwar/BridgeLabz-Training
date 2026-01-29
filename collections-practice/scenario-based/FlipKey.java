import java.util.*;
public class FlipKey {

    public String cleanseAndInvert(String s){
        if(s==null || s.length() < 6)
            return "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>'z' || s.charAt(i)<'A' || (s.charAt(i)<'a' && s.charAt(i)>'Z'))
                return "";
        }
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)%2==0){
                sb.delete(i,i+1);
                i--;
            }
        }
        sb = sb.reverse();
        for(int i=0;i<sb.length();i+=2){
            sb.setCharAt(i,(char)(sb.charAt(i)-32));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter a Word : ");
        String s = sc.nextLine();
        sc.close();
        FlipKey fk = new FlipKey();
        if(fk.cleanseAndInvert(s).equals(""))
            System.out.println("Invalid Input !");
        else
            System.out.println("The Generated Key is : "+fk.cleanseAndInvert(s));
    }
}
