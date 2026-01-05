import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder("");
        int max = 0 ;
        for(int i=0;i<s.length();i++){
             sb = new StringBuilder("");
            for(int j=i;j<s.length();j++){
                if(sb.toString().contains(""+s.charAt(j))){
                    break ;
                } else
                sb.append(s.charAt(j));
                if(max < sb.length())
                    max = sb.length();
            }
        }
        if(max < sb.length())
            max = sb.length();
        return max ;
    }
}
public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter a String : ");
        String s = sc.nextLine();
        sc.close();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
