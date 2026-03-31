import java.util.*;
public class LexicalTwist {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter First Word : ");
        String s1 = sc.nextLine();
        if(s1.contains(" ")){
            sc.close();
            System.out.println(s1+" is a Invalid Word !");
            return ;
        }
        System.out.print("Enter Second Word : ");
        String s2 = sc.nextLine();
        if(s2.contains(" ")){
            sc.close();
            System.out.println(s2+" is a Invalid Word !");
            return ;
        }
        sc.close();

        String removeSymbolsFromS1 = "";
        for(int i=0;i<s1.length();i++){
            if((s1.charAt(i)>='a' && s1.charAt(i)<='z') || (s1.charAt(i)>='A' && s1.charAt(i)<='Z'))
                removeSymbolsFromS1+=s1.charAt(i);
        }
        s1 = removeSymbolsFromS1;
        String removeSymbolsFromS2 = "";
        for(int i=0;i<s2.length();i++){
            if((s2.charAt(i)>='a' && s2.charAt(i)<='z') || (s2.charAt(i)>='A' && s2.charAt(i)<='Z'))
                removeSymbolsFromS2+=s2.charAt(i);
        }
        s2 = removeSymbolsFromS2;

        String s = "";
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        StringBuilder sb2 = new StringBuilder(s2);
        if(sb2.reverse().toString().equals(s1)){
            for(int i=s1.length()-1;i>=0;i--){
                if(s1.charAt(i)=='a' || s1.charAt(i)=='e' || s1.charAt(i)=='i' || s1.charAt(i)=='o' || s1.charAt(i)=='u')
                    s+='@' ;
                else
                    s+=s1.charAt(i);
            }
            System.out.println(s);
            return ;
        }

        s = (s1+s2).toUpperCase();
        int consonants = 0 ;
        int vowels = 0 ;
        String twoConsonants = "";
        String twoVowels = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A' || s.charAt(i)=='E' || s.charAt(i)=='I' || s.charAt(i)=='O' || s.charAt(i)=='U'){
                vowels++;
                if(twoVowels.length() < 2 && !twoVowels.contains(""+s.charAt(i)))
                    twoVowels+=s.charAt(i);
            }
            else{
                consonants++;
                if(twoConsonants.length() < 2 && !twoConsonants.contains(""+s.charAt(i)))
                    twoConsonants+=s.charAt(i);
            }
        }
        if(vowels == consonants)
            System.out.println("Vowels and Consonants are Equal !");
        else if(vowels > consonants)
            System.out.println(twoVowels);
        else
            System.out.println(twoConsonants);
    }
}
