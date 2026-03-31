import java.util.*;
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Array : ");
        int size = sc.nextInt();
        String[] strs = new String[size];
        System.out.println("Enter Elements of Array : ");
        for (int i = 0; i < size; i++) {
            strs[i] = sc.next();
        }
        sc.close();
        String s = "";
        for(int i=0;i<strs[0].length();i++){
            for(int j=1;j<strs.length;j++){
                if( strs[j].length()==i || strs[0].charAt(i)!=strs[j].charAt(i)){
                    System.out.print(s);
                    return ;
                }
            }
            s += strs[0].charAt(i);
        }
        System.out.println("Longest Common Prefix : "+s);
        
    }
}
