import java.util.*;

public class IndexOfFirstOccurenceOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String haystack = sc.nextLine();
        String needle = sc.nextLine();
        sc.close();
        int haylength=haystack.length();
        int needlelength=needle.length();
        if(haylength<needlelength){
            System.out.println(-1);
            return;
        }
        for(int i=0;i<=haystack.length()-needle.length();i++){
            int j=0;
            while(j<needle.length() && haystack.charAt(i+j)==needle.charAt(j))
                j++;
            if(j==needle.length()){
                System.out.println(i);
                return; 
            }
        }
        System.out.println(-1);
    }
}
